package com.g64.controller;

import com.g64.controller.action.*;
import com.g64.exceptions.*;
import com.g64.model.ChunkModel;
import com.g64.model.InventoryModel;
import com.g64.model.MapModel;
import com.g64.model.Position;
import com.g64.model.entities.Player;
import com.g64.model.items.tools.Tool;
import com.g64.view.EntityView;
import com.g64.view.InventoryView;
import com.g64.view.MapView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;


public class actionEventTest {
    private GameController controller;
    private MapModel map;
    private InventoryModel inventory;
    private Player player;
    private Tool tool;
    private Position position;

    @Before
    public void initGameController() {
        map = Mockito.mock(MapModel.class);
        inventory = Mockito.mock(InventoryModel.class);
        player = Mockito.mock(Player.class);
        tool = Mockito.mock(Tool.class);
        position = Mockito.mock(Position.class);
        controller = new GameController(player, map, Mockito.mock(MapView.class), Mockito.mock(EntityView.class), inventory, Mockito.mock(InventoryView.class));
        Mockito.when(map.thisChunk()).thenReturn(Mockito.mock(ChunkModel.class));
        Mockito.when(inventory.getSelectedItem()).thenReturn(tool);
        Mockito.when(player.getPosition()).thenReturn(Mockito.mock(Position.class));
    }

    @Test
    public void actionRightNewChunk() throws CrossedRight, Died {
        MoveRight move = Mockito.mock(MoveRight.class); doThrow(CrossedRight.class).when(move).execute();
        controller.processPlayerAction(move);
        verify(controller.getMapModel()).moveEast();
    }

    @Test
    public void actionLeftNewChunk() throws CrossedLeft, Died {
        MoveLeft move = Mockito.mock(MoveLeft.class); doThrow(CrossedLeft.class).when(move).execute();
        controller.processPlayerAction(move);
        verify(controller.getMapModel()).moveWest();
    }

    @Test
    public void actionUpNewChunk() throws CrossedUp, Died {
        MoveUp move = Mockito.mock(MoveUp.class); doThrow(CrossedUp.class).when(move).execute();
        controller.processPlayerAction(move);
        verify(controller.getMapModel()).moveNorth();
    }

    @Test
    public void actionDownNewChunk() throws CrossedDown, Died {
        MoveDown move = Mockito.mock(MoveDown.class); doThrow(CrossedDown.class).when(move).execute();
        controller.processPlayerAction(move);
        verify(controller.getMapModel()).moveSouth();
    }

    //@Test
    //public void interactDownWithTool() {
    //    InteractDown interact = new InteractDown(controller)
    //    controller.processPlayerAction(interact);
    //    verify(tool).use(controller, position);
    //}
    //TODO interactiontests

}
