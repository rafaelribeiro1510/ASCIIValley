package com.g64.model;

import com.g64.controller.GameController;
import com.g64.controller.commands.*;
import com.g64.model.entities.Player;
import com.g64.model.gameState.ControlsState;
import com.g64.model.gameState.DeadPlayerState;
import com.g64.model.gameState.InGameState;
import com.g64.model.gameState.MainMenuGameState;
import com.g64.view.*;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class InputTest {

    private GameController controller;

    private KeyStroke w;
    private KeyStroke a;
    private KeyStroke s;
    private KeyStroke d;
    private KeyStroke arrowUp;
    private KeyStroke arrowDown;
    private KeyStroke arrowLeft;
    private KeyStroke arrowRight;
    private KeyStroke zero;
    private KeyStroke nine;
    private KeyStroke escape;

    @Before
    public void initGameController() {
        controller = new GameController(
                Mockito.mock(Player.class),
                Mockito.mock(Display.class),
                Mockito.mock(MapModel.class),
                Mockito.mock(MapView.class),
                Mockito.mock(InventoryModel.class)
        );
        MainMenuView mainMenuView = Mockito.mock(MainMenuView.class);

        controller.setControlsState(new ControlsState(controller, Mockito.mock(ControlsView.class)));
        controller.setDeadPlayerState(new DeadPlayerState(controller, Mockito.mock(DeadView.class)));
        controller.setInGameState(new InGameState(controller, Mockito.mock(EntityView.class), Mockito.mock(InventoryView.class)));
        controller.setMenuGameState(new MainMenuGameState(controller, mainMenuView));

        controller.setGameState(controller.getMenuGameState());


        w = Mockito.mock(KeyStroke.class);
        when(w.getKeyType()).thenReturn(KeyType.Character);
        when(w.getCharacter()).thenReturn('w');

        a = Mockito.mock(KeyStroke.class);
        when(a.getKeyType()).thenReturn(KeyType.Character);
        when(a.getCharacter()).thenReturn('a');

        s = Mockito.mock(KeyStroke.class);
        when(s.getKeyType()).thenReturn(KeyType.Character);
        when(s.getCharacter()).thenReturn('s');

        d = Mockito.mock(KeyStroke.class);
        when(d.getKeyType()).thenReturn(KeyType.Character);
        when(d.getCharacter()).thenReturn('d');

        zero = Mockito.mock(KeyStroke.class);
        when(zero.getKeyType()).thenReturn(KeyType.Character);
        when(zero.getCharacter()).thenReturn('0');

        nine = Mockito.mock(KeyStroke.class);
        when(nine.getKeyType()).thenReturn(KeyType.Character);
        when(nine.getCharacter()).thenReturn('9');

        arrowUp = Mockito.mock(KeyStroke.class);
        when(arrowUp.getKeyType()).thenReturn(KeyType.ArrowUp);

        arrowDown = Mockito.mock(KeyStroke.class);
        when(arrowDown.getKeyType()).thenReturn(KeyType.ArrowDown);

        arrowLeft = Mockito.mock(KeyStroke.class);
        when(arrowLeft.getKeyType()).thenReturn(KeyType.ArrowLeft);

        arrowRight = Mockito.mock(KeyStroke.class);
        when(arrowRight.getKeyType()).thenReturn(KeyType.ArrowRight);

        escape = Mockito.mock(KeyStroke.class);
        when(escape.getKeyType()).thenReturn(KeyType.Escape);
    }

    @Test
    public void inGameProcessInput() {
        controller.setGameState(controller.getInGameState());

        Screen screen = Mockito.mock(Screen.class);
        when(controller.getDisplay().getScreen()).thenReturn(screen);

        try {
            when(controller.getDisplay().getScreen().pollInput()).thenReturn(w);
            assertEquals(MoveUp.class, controller.getGameState().keyStrokeToActionEvent(controller.getKeyStroke()).getClass());

            when(controller.getDisplay().getScreen().pollInput()).thenReturn(s);
            assertEquals(MoveDown.class, controller.getGameState().keyStrokeToActionEvent(controller.getKeyStroke()).getClass());

            when(controller.getDisplay().getScreen().pollInput()).thenReturn(a);
            assertEquals(MoveLeft.class, controller.getGameState().keyStrokeToActionEvent(controller.getKeyStroke()).getClass());

            when(controller.getDisplay().getScreen().pollInput()).thenReturn(d);
            assertEquals(MoveRight.class, controller.getGameState().keyStrokeToActionEvent(controller.getKeyStroke()).getClass());

            when(controller.getDisplay().getScreen().pollInput()).thenReturn(zero);
            assertEquals(SelectSlot.class, controller.getGameState().keyStrokeToActionEvent(controller.getKeyStroke()).getClass());

            when(controller.getDisplay().getScreen().pollInput()).thenReturn(nine);
            assertEquals(SelectSlot.class, controller.getGameState().keyStrokeToActionEvent(controller.getKeyStroke()).getClass());

            when(controller.getDisplay().getScreen().pollInput()).thenReturn(arrowUp);
            assertEquals(InteractUp.class, controller.getGameState().keyStrokeToActionEvent(controller.getKeyStroke()).getClass());

            when(controller.getDisplay().getScreen().pollInput()).thenReturn(arrowDown);
            assertEquals(InteractDown.class, controller.getGameState().keyStrokeToActionEvent(controller.getKeyStroke()).getClass());

            when(controller.getDisplay().getScreen().pollInput()).thenReturn(arrowLeft);
            assertEquals(InteractLeft.class, controller.getGameState().keyStrokeToActionEvent(controller.getKeyStroke()).getClass());

            when(controller.getDisplay().getScreen().pollInput()).thenReturn(arrowRight);
            assertEquals(InteractRight.class, controller.getGameState().keyStrokeToActionEvent(controller.getKeyStroke()).getClass());

            when(controller.getDisplay().getScreen().pollInput()).thenReturn(escape);
            assertEquals(GoToPauseMenu.class, controller.getGameState().keyStrokeToActionEvent(controller.getKeyStroke()).getClass());

        }
        catch(IOException e) { e.printStackTrace(); }

    }
}
