package com.g64.view;

import com.g64.model.ChunkModel;
import com.g64.model.MapModel;
import com.g64.model.Position;
import com.g64.model.entities.EntityModel;
import com.g64.model.entities.plant.TallGrassEntity;
import com.g64.model.terrain.GrassTerrain;
import com.g64.model.terrain.MapTerrain;
import com.googlecode.lanterna.screen.Screen;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MapViewTest {

    private ArrayList<MapTerrain> terrain;
    private ArrayList<EntityModel> entity;
    private ArrayList<Integer> neighbors;
    private ChunkModel chunkModel;


    @Before
    public void init() {
        terrain = new ArrayList<>(
                Arrays.asList(new GrassTerrain(new Position(0,0), 1))
        );

        entity = new ArrayList<>(
                Arrays.asList(new TallGrassEntity(new Position(0,0)))
        );

        neighbors = new ArrayList<>(); neighbors.add(2); neighbors.add(3); neighbors.add(4); neighbors.add(5);


        chunkModel = new ChunkModel(
                1, 1, 1, neighbors, terrain, entity);
    }

    @Test
    public void chunkViewTest() {

        EntityView entityView = Mockito.mock(EntityView.class);
        ChunkView chunkView = new ChunkView(entityView);

        chunkView.draw(chunkModel);

        verify(entityView).draw(chunkModel.getEntityAt(new Position(0,0)), chunkModel);

    }

    @Test
    public void mapViewTest() {
        ChunkView chunkView = Mockito.mock(ChunkView.class);
        MapModel mapModel = Mockito.mock(MapModel.class);
        when(mapModel.thisChunk()).thenReturn(chunkModel);

        Screen screen = Mockito.mock(Screen.class);
        MapView mapView = new MapView(screen, chunkView);
        mapView.draw(mapModel);
        verify(chunkView).draw(chunkModel);
    }



}
