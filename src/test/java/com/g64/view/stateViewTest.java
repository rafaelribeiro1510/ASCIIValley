package com.g64.view;

import com.g64.controller.GameController;
import com.g64.model.ChunkModel;
import com.g64.model.InventoryModel;
import com.g64.model.MapModel;
import com.g64.model.entities.Player;
import com.g64.model.gameState.ControlsState;
import com.g64.model.gameState.DeadPlayerState;
import com.g64.model.gameState.InGameState;
import com.g64.model.gameState.MainMenuGameState;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class stateViewTest {

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
    public void mainMenuExecute() {
        when(controller.getDisplay().getScreen()).thenReturn(Mockito.mock(Screen.class));
        when(controller.getDisplay().getScreen().newTextGraphics()).thenReturn(Mockito.mock(TextGraphics.class));
        MenuView menuView = Mockito.mock(MenuView.class);
        MainMenuGameState mainMenu = new MainMenuGameState(controller, menuView);

        mainMenu.execute();

        verify(menuView).draw(mainMenu);
    }

    @Test
    public void controlsExecuteView() {

        ControlsView controlsView = Mockito.mock(ControlsView.class);
        ControlsState controls = new ControlsState(controller, controlsView);

        controls.execute();

        verify(controlsView).draw();
    }

    @Test
    public void deadPlayerExecute() {

        DeadView deadview = Mockito.mock(DeadView.class);
        DeadPlayerState deadPlayer = new DeadPlayerState(controller, deadview);

        deadPlayer.execute();

        verify(deadview).draw();
    }


    @Test
    public void inGameExecute() {
        when(controller.getMapModel().thisChunk()).thenReturn(Mockito.mock(ChunkModel.class));
        // when(controller.getMapModel().updateEntities(controller)).thenReturn(new ArrayList<ActionEvent>());
        EntityView entityView = Mockito.mock(EntityView.class);
        InventoryView inventoryView = Mockito.mock(InventoryView.class);

        InGameState game = new InGameState(controller, entityView, inventoryView);

        game.execute();
    }

}
