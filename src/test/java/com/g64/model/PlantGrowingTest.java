package com.g64.model;

import com.g64.controller.GameController;
import com.g64.controller.Commands.Command;
import com.g64.model.entities.EntityModel;
import com.g64.model.entities.Player;
import com.g64.model.entities.plant.CarrotSeedEntity;
import com.g64.model.entities.plant.CornSeedEntity;
import com.g64.model.terrain.MapTerrain;
import com.g64.model.terrain.SoilTerrain;
import com.g64.view.Display;
import com.g64.view.MapView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PlantGrowingTest {
    private GameController controller;
    private MapModel mapSpy;
    private ChunkModel chunk;

    @Before
    public void initGameController() {
        ArrayList<MapTerrain> terrain = new ArrayList<>();
        terrain.add(new SoilTerrain(new Position(0,0), 1));
        terrain.add(new SoilTerrain(new Position(0,1), 1));
        terrain.add(new SoilTerrain(new Position(1,0), 1));
        terrain.add(new SoilTerrain(new Position(1,1), 1));
        ArrayList<EntityModel> entities = new ArrayList<>();
        entities.add(new CarrotSeedEntity(new Position(0,0), 2));
        entities.add(new CornSeedEntity(new Position(1,1), 2));

        ArrayList<Integer> neighbors = new ArrayList<>(); neighbors.add(2); neighbors.add(3); neighbors.add(4); neighbors.add(5);
        chunk = new ChunkModel(2, 2, 1, neighbors, terrain, entities);
        ArrayList<ChunkModel> chunks = new ArrayList<>(); chunks.add(chunk);
        MapModel map = new MapModel(1, chunks);
        mapSpy = Mockito.spy(map);

        controller = new GameController(Mockito.mock(Player.class), Mockito.mock(Display.class), mapSpy, Mockito.mock(MapView.class), Mockito.mock(InventoryModel.class));
    }

    @Test
    public void growTest(){
        assertTrue(chunk.getEntityAt(new Position(0,0)) instanceof CarrotSeedEntity);
        assertTrue(chunk.getEntityAt(new Position(1,1)) instanceof CornSeedEntity);

        for (Command event: mapSpy.updateEntities(controller)) controller.processAction(event);

        assertTrue(chunk.getEntityAt(new Position(0,0)) instanceof CarrotSeedEntity);
        assertTrue(chunk.getEntityAt(new Position(1,1)) instanceof CornSeedEntity);

        for (Command event: mapSpy.updateEntities(controller)) controller.processAction(event);

        assertFalse(chunk.getEntityAt(new Position(0,0)) instanceof CarrotSeedEntity);
        assertFalse(chunk.getEntityAt(new Position(1,1)) instanceof CornSeedEntity);
    }

}
