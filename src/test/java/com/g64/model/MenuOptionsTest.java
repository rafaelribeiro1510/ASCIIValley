package com.g64.model;

import com.g64.controller.GameController;
import com.g64.controller.action.MenuDown;
import com.g64.controller.action.MenuUp;
import com.g64.model.entities.Player;
import com.g64.model.gameState.MainMenuGameState;
import com.g64.view.Display;
import com.g64.view.MapView;
import com.g64.view.MenuView;
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
        MenuView menuView = Mockito.mock(MenuView.class);
        controller.setGameState(new MainMenuGameState(controller, menuView));
    }

    @Test
    public void playOptionTest() {

        assertEquals(0, ((MainMenuGameState) controller.getGameState()).getSelectedOption());
        assertEquals("Play",
                ((MainMenuGameState) controller.getGameState()).getMenuOptions().get(
                        ((MainMenuGameState) controller.getGameState()).getSelectedOption()
                ).getOptionText()
        );
    }

    @Test
    public void controlsOptionTest() {
        controller.processAction(new MenuDown((MainMenuGameState) controller.getGameState()));
        assertEquals(1, ((MainMenuGameState) controller.getGameState()).getSelectedOption());
        assertEquals("Controls", ((MainMenuGameState) controller.getGameState()).getMenuOptions(
                ).get(
                ((MainMenuGameState) controller.getGameState()).getSelectedOption()
                ).getOptionText()
        );
    }

    @Test public void quitOptionTest() {
        controller.processAction(new MenuDown((MainMenuGameState)controller.getGameState()));
        controller.processAction(new MenuDown((MainMenuGameState)controller.getGameState()));

        assertEquals(2, ((MainMenuGameState) controller.getGameState()).getSelectedOption());
        assertEquals("Quit", ((MainMenuGameState) controller.getGameState()).getMenuOptions(
                ).get(
                ((MainMenuGameState) controller.getGameState()).getSelectedOption()
                ).getOptionText()
        );
    }

    // Check if it stays at the first option after Arrow Up input
    @Test
    public void upOverflowTest() {

        controller.processAction(new MenuUp((MainMenuGameState) controller.getGameState()));
        assertEquals(0, ((MainMenuGameState) controller.getGameState()).getSelectedOption());
    }

    // Check if it stays at the last option after Arrow Down input
    @Test
    public void downOverflowTest() {
        // Start at the last option
        MainMenuGameState menu = (MainMenuGameState)controller.getGameState();
        menu.setSelectedOption(2);

        controller.processAction(new MenuDown((MainMenuGameState)controller.getGameState()));
        assertEquals(2, ((MainMenuGameState) controller.getGameState()).getSelectedOption());
    }

}
