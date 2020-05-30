package com.g64.model;

import com.g64.controller.GameController;
import com.g64.controller.action.*;
import com.g64.exceptions.Died;
import com.g64.model.entities.Player;
import com.g64.model.gameState.controlsState;
import com.g64.model.gameState.inGameState;
import com.g64.model.gameState.menuGameState;
import com.g64.view.Display;
import com.g64.view.MapView;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import net.bytebuddy.asm.Advice;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.configuration.injection.MockInjection;

import java.awt.event.KeyEvent;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
    }

    @Test
    public void menuToInGameStateTest() {
        when(controller.getDisplay().getScreen()).thenReturn(Mockito.mock(Screen.class));

        // checks if gameState is initially menuGameState (in menu)
        assertEquals(menuGameState.class, controller.getGameState().getClass());

        controller.processAction(new EnterPressed((menuGameState)controller.getGameState()));

        // checks if gameState changed from menuGameState to inGameState
        assertEquals(inGameState.class, controller.getGameState().getClass());
    }

    @Test
    public void menuToControlsStateTest() {
        // checks if gameState is initially menuGameState (in menu)
        assertEquals(menuGameState.class, controller.getGameState().getClass());

        controller.processAction(new MenuDown((menuGameState)controller.getGameState()));
        controller.processAction(new EnterPressed((menuGameState)controller.getGameState()));

        // checks if gameState changed from menuGameState to controlsState
        assertEquals(controlsState.class, controller.getGameState().getClass());
    }

    @Test
    public void controlsToMenuStateTest() {

        when(controller.getMapView().getScreen()).thenReturn(Mockito.mock(Screen.class));

        // to "start" at the controls menu
        controller.setGameState(new controlsState(controller));

        // checks "starting" state
        assertEquals(controlsState.class, controller.getGameState().getClass());
        controller.processAction(new ExitToMainMenu(controller));

        // checks if gameState changed from controlsState to menuGameState
        assertEquals(menuGameState.class, controller.getGameState().getClass());
    }

    @Test
    public void menuToQuitStateTest() {
        Screen mocked = Mockito.mock(Screen.class);
        when(controller.getMapView().getScreen()).thenReturn(mocked);

        // checks "starting" state
        assertEquals(menuGameState.class, controller.getGameState().getClass());

        controller.processAction(new MenuDown((menuGameState)controller.getGameState()));
        controller.processAction(new MenuDown((menuGameState)controller.getGameState()));

        // selected "Quit" option
        controller.processAction(new EnterPressed((menuGameState)controller.getGameState()));

        // checks if the close screen method was called (once)
        try { verify(mocked).close(); }
        catch (IOException e) { e.printStackTrace(); }
    }

}
