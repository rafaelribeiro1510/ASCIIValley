package com.g64.view;

import com.g64.controller.GameController;
import com.g64.model.InventoryModel;
import com.g64.model.MapModel;
import com.g64.model.entities.Player;
import com.g64.model.gameState.ControlsState;
import com.g64.model.gameState.DeadPlayerState;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

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

}
