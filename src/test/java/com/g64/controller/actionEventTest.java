package com.g64.controller;

import com.g64.controller.action.*;
import com.g64.exceptions.Died;
import com.g64.model.ChunkModel;
import com.g64.model.InventoryModel;
import com.g64.model.MapModel;
import com.g64.model.Position;
import com.g64.model.entities.EntityModel;
import com.g64.model.entities.Player;
import com.g64.model.entities.enemy.Mummy;
import com.g64.model.entities.map.RockEntity;
import com.g64.model.entities.plant.TallGrassEntity;
import com.g64.model.items.tools.Tool;
import com.g64.model.terrain.GrassTerrain;
import com.g64.model.terrain.MapTerrain;
import com.g64.model.terrain.SoilTerrain;
import com.g64.model.terrain.StoneTerrain;
import com.g64.view.EntityView;
import com.g64.view.InventoryView;
import com.g64.view.MapView;
import com.googlecode.lanterna.TextColor;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;


public class actionEventTest {
    private GameController controller;
    private MapModel mapSpy;
    private ChunkModel chunk;
    private InventoryModel inventory;
    private Player playerSpy;
    private Tool tool;

    @Before
    public void initGameController() {
        ArrayList<MapTerrain> terrain = new ArrayList<>();
            terrain.add(new GrassTerrain(new Position(0,0)));
            terrain.add(new SoilTerrain(new Position(0,1)));
            terrain.add(new GrassTerrain(new Position(1,0)));
            terrain.add(new StoneTerrain(new Position(1,1)));
        ArrayList<EntityModel> entities = new ArrayList<>();
            entities.add(new TallGrassEntity(new Position(1,0)));
            entities.add(new RockEntity(new Position(1,1)));

        ArrayList<Integer> neighbors = new ArrayList<>(); neighbors.add(2); neighbors.add(3); neighbors.add(4); neighbors.add(5);
        chunk = new ChunkModel(2, 2, 1, neighbors, terrain, entities);
        ArrayList<ChunkModel> chunks = new ArrayList<>(); chunks.add(chunk);
        MapModel map = new MapModel(1, chunks);
        mapSpy = Mockito.spy(map);

        inventory = Mockito.mock(InventoryModel.class);
        Player player = new Player(new Position(0,0)," ", Mockito.mock(TextColor.class));
        playerSpy = Mockito.spy(player);
        tool = Mockito.mock(Tool.class);
        controller = new GameController(playerSpy, mapSpy, Mockito.mock(MapView.class), Mockito.mock(EntityView.class), inventory, Mockito.mock(InventoryView.class));
        Mockito.when(inventory.getSelectedItem()).thenReturn(tool);
    }

    @Test
    public void moveRightNewChunk() {
        playerSpy.setPosition(new Position(1,0));
        MoveRight move = new MoveRight(controller, playerSpy);
        controller.processAction(move);
        verify(controller.getMapModel()).moveEast();
    }

    @Test
    public void moveLeftNewChunk() {
        playerSpy.setPosition(new Position(0,0));
        MoveLeft move = new MoveLeft(controller, playerSpy);
        controller.processAction(move);
        verify(controller.getMapModel()).moveWest();
    }

    @Test
    public void moveUpNewChunk() {
        playerSpy.setPosition(new Position(0,0));
        MoveUp move = new MoveUp(controller, playerSpy);
        controller.processAction(move);
        verify(controller.getMapModel()).moveNorth();
    }

    @Test
    public void moveDownNewChunk() {
        playerSpy.setPosition(new Position(0,1));
        MoveDown move = new MoveDown(controller, playerSpy);
        controller.processAction(move);
        verify(controller.getMapModel()).moveSouth();
    }

    @Test
    public void moveTestCollision(){
        playerSpy.setPosition(new Position(0,0));
        MoveLeft left = new MoveLeft(controller, playerSpy);
        controller.processAction(left);
        assertEquals(new Position(1,0), playerSpy.getPosition());

        MoveDown down = new MoveDown(controller,playerSpy);
        controller.processAction(down);
        assertEquals(new Position(1,0), playerSpy.getPosition());
    }

    @Test
    public void moveTestDamage() throws Died {
        playerSpy.setPosition(new Position(0,0));
        Mummy mummy = new Mummy(new Position(1,0));
        mapSpy.thisChunk().getEntities().add(mummy);
        MoveLeft left = new MoveLeft(controller, mummy);
        controller.processAction(left);
        verify(playerSpy).reduceHealth(mummy.getAttackValue());
    }
    

}
