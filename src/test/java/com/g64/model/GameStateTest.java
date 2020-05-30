package com.g64.model;

import com.g64.controller.GameController;
import com.g64.controller.action.*;
import com.g64.exceptions.Died;
import com.g64.model.entities.Player;
import com.g64.model.gameState.menuGameState;
import com.g64.view.MapView;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.configuration.injection.MockInjection;

import java.awt.event.KeyEvent;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class GameStateTest {

    private GameController controller;

    @Before
    public void initGameController() {
        controller = new GameController(
                Mockito.mock(Player.class),
                Mockito.mock(MapModel.class),
                Mockito.mock(MapView.class),
                Mockito.mock(InventoryModel.class)
        );
    }

    @Test
    public void menuOptionsTest() {

        assertEquals(0, ((menuGameState) controller.getGameState()).getSelectedOption());
        assertEquals("Play", ((menuGameState) controller.getGameState()).getMenuOptions(
        ).get(
                ((menuGameState) controller.getGameState()).getSelectedOption()
             ).getOptionText()
        );

        controller.processAction(new MenuUp((menuGameState)controller.getGameState()));
        assertEquals(0, ((menuGameState) controller.getGameState()).getSelectedOption());

        controller.processAction(new MenuDown((menuGameState)controller.getGameState()));
        assertEquals(1, ((menuGameState) controller.getGameState()).getSelectedOption());
        assertEquals("Controls", ((menuGameState) controller.getGameState()).getMenuOptions(
                ).get(
                ((menuGameState) controller.getGameState()).getSelectedOption()
                ).getOptionText()
        );

        controller.processAction(new MenuDown((menuGameState)controller.getGameState()));
        assertEquals(2, ((menuGameState) controller.getGameState()).getSelectedOption());
        assertEquals("Quit", ((menuGameState) controller.getGameState()).getMenuOptions(
                ).get(
                ((menuGameState) controller.getGameState()).getSelectedOption()
                ).getOptionText()
        );

        controller.processAction(new MenuDown((menuGameState)controller.getGameState()));
        assertEquals(2, ((menuGameState) controller.getGameState()).getSelectedOption());

    }

    
}
