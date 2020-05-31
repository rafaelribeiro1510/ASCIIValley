package com.g64.model;

import com.g64.controller.GameController;
import com.g64.controller.action.MenuDown;
import com.g64.controller.action.MenuUp;
import com.g64.model.entities.Player;
import com.g64.model.gameState.MenuGameState;
import com.g64.view.Display;
import com.g64.view.MapView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class MenuOptionsTest {

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

        controller.setGameState(new MenuGameState(controller));
    }

    @Test
    public void playOptionTest() {

        assertEquals(0, ((MenuGameState) controller.getGameState()).getSelectedOption());
        assertEquals("Play",
                ((MenuGameState) controller.getGameState()).getMenuOptions().get(
                        ((MenuGameState) controller.getGameState()).getSelectedOption()
                ).getOptionText()
        );
    }

    @Test
    public void controlsOptionTest() {
        controller.processAction(new MenuDown((MenuGameState) controller.getGameState()));
        assertEquals(1, ((MenuGameState) controller.getGameState()).getSelectedOption());
        assertEquals("Controls", ((MenuGameState) controller.getGameState()).getMenuOptions(
                ).get(
                ((MenuGameState) controller.getGameState()).getSelectedOption()
                ).getOptionText()
        );
    }

    @Test public void quitOptionTest() {
        controller.processAction(new MenuDown((MenuGameState)controller.getGameState()));
        controller.processAction(new MenuDown((MenuGameState)controller.getGameState()));

        assertEquals(2, ((MenuGameState) controller.getGameState()).getSelectedOption());
        assertEquals("Quit", ((MenuGameState) controller.getGameState()).getMenuOptions(
                ).get(
                ((MenuGameState) controller.getGameState()).getSelectedOption()
                ).getOptionText()
        );
    }

    // Check if it stays at the first option after Arrow Up input
    @Test
    public void upOverflowTest() {

        controller.processAction(new MenuUp((MenuGameState) controller.getGameState()));
        assertEquals(0, ((MenuGameState) controller.getGameState()).getSelectedOption());
    }

    // Check if it stays at the last option after Arrow Down input
    @Test
    public void downOverflowTest() {
        // Start at the last option
        MenuGameState menu = (MenuGameState)controller.getGameState();
        menu.setSelectedOption(2);

        controller.processAction(new MenuDown((MenuGameState)controller.getGameState()));
        assertEquals(2, ((MenuGameState) controller.getGameState()).getSelectedOption());
    }

}
