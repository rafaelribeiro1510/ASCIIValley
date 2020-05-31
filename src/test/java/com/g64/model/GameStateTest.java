package com.g64.model;

import com.g64.controller.GameController;
import com.g64.controller.action.*;
import com.g64.model.entities.EntityModel;
import com.g64.model.entities.Player;
import com.g64.model.gameState.ControlsState;
import com.g64.model.gameState.InGameState;
import com.g64.model.gameState.MenuGameState;
import com.g64.model.gameState.DeadPlayerState;
import com.g64.view.*;
import com.googlecode.lanterna.screen.Screen;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class GameStateTest {

    private GameController controller;

    @Before
    public void initGameController() {
        controller = new GameController(
                Mockito.mock(Player.class),
                Mockito.mock(Display.class),
                Mockito.mock(MapModel.class),
                Mockito.mock(MapView.class),
                Mockito.mock(InventoryModel.class)
        );

        controller.setControlsState(new ControlsState(controller, Mockito.mock(ControlsView.class)));
        controller.setDeadPlayerState(new DeadPlayerState(controller, Mockito.mock(DeadView.class)));
        controller.setInGameState(new InGameState(controller, Mockito.mock(EntityView.class), Mockito.mock(InventoryView.class)));
        controller.setMenuGameState(new MenuGameState(controller));

        controller.setGameState(controller.getMenuGameState());
    }

    @Test
    public void menuToInGameStateTest() {
        when(controller.getDisplay().getScreen()).thenReturn(Mockito.mock(Screen.class));

        // checks if gameState is initially MenuGameState (in menu)
        assertEquals(MenuGameState.class, controller.getGameState().getClass());

        controller.processAction(new EnterPressed((MenuGameState)controller.getGameState()));

        // checks if gameState changed from MenuGameState to InGameState
        assertEquals(InGameState.class, controller.getGameState().getClass());
    }

    @Test
    public void menuToControlsStateTest() {
        when(controller.getDisplay().getScreen()).thenReturn(Mockito.mock(Screen.class));

        // checks if gameState is initially MenuGameState (in menu)
        assertEquals(MenuGameState.class, controller.getGameState().getClass());

        controller.processAction(new MenuDown((MenuGameState)controller.getGameState()));
        controller.processAction(new EnterPressed((MenuGameState)controller.getGameState()));

        // checks if gameState changed from MenuGameState to ControlsState
        assertEquals(ControlsState.class, controller.getGameState().getClass());
    }

    @Test
    public void controlsToMenuStateTest() {
        when(controller.getDisplay().getScreen()).thenReturn(Mockito.mock(Screen.class));
        when(controller.getMapView().getScreen()).thenReturn(Mockito.mock(Screen.class));

        // to "start" at the controls menu
        // controller.setGameState(new ControlsState(controller));
        controller.setGameState(controller.getControlsState());

        // checks "starting" state
        assertEquals(ControlsState.class, controller.getGameState().getClass());
        controller.processAction(new ExitToMainMenu(controller));

        // checks if gameState changed from ControlsState to MenuGameState
        assertEquals(MenuGameState.class, controller.getGameState().getClass());
    }

    @Test
    public void menuToQuitStateTest() {
        Screen mocked = Mockito.mock(Screen.class);
        when(controller.getMapView().getScreen()).thenReturn(mocked);

        // checks "starting" state
        assertEquals(MenuGameState.class, controller.getGameState().getClass());

        controller.processAction(new MenuDown((MenuGameState)controller.getGameState()));
        controller.processAction(new MenuDown((MenuGameState)controller.getGameState()));

        // selected "Quit" option
        controller.processAction(new EnterPressed((MenuGameState)controller.getGameState()));

        // checks if the close screen method was called (once)
        try { verify(mocked).close(); }
        catch (IOException e) { e.printStackTrace(); }
    }

    @Test
    public void inGameToDeadStateTest() {
        Screen mocked = Mockito.mock(Screen.class);
        when(controller.getMapView().getScreen()).thenReturn(mocked);
        when(controller.getDisplay().getScreen()).thenReturn(mocked);

        when(controller.getPlayer().reduceHealth(anyInt())).thenReturn(EntityModel.healthReduction.DIED);

        // to "start" in game
        // controller.setGameState(new InGameState(controller));
        controller.setGameState(controller.getInGameState());

        // controller.getPlayer().reduceHealth(anyInt());
        controller.processAction(new AttackPlayer(controller, anyInt()));

        assertEquals(DeadPlayerState.class, controller.getGameState().getClass());

        controller.processAction(new QuitGame(controller));

        // checks if the close screen method was called (once)
        try { verify(mocked).close(); }
        catch (IOException e) { e.printStackTrace(); }

    }

}
