package com.g64.model;

import com.g64.controller.GameController;
import com.g64.model.entities.EntityModel;
import com.g64.model.entities.enemy.Mummy;
import com.g64.model.entities.plant.TallGrassEntity;
import com.g64.model.entities.visitors.ItemVisitor;
import com.g64.model.items.tools.Axe;
import com.g64.model.items.tools.Tool;
import com.g64.model.terrain.NullTerrain;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ToolTest {
    GameController controller;
    MapModel map;
    ChunkModel chunkSpy;
    InventoryModel inventorySpy;

    TallGrassEntity grass;
    Mummy mummySpy;

    @SuppressWarnings("unchecked")
    @Before
    public void initChunk(){
        grass = new TallGrassEntity(new Position(0,0));
        Mummy mummy = new Mummy(new Position(1,1));
        mummySpy = Mockito.spy(mummy);

        InventoryModel inventory = new InventoryModel();
        inventorySpy = Mockito.spy(inventory);

        ArrayList<EntityModel> entities = new ArrayList<>(); entities.add(grass); entities.add(mummySpy);
        ChunkModel chunk = new ChunkModel(2,2,1, Mockito.mock(ArrayList.class), Mockito.mock(ArrayList.class), entities);
        chunkSpy = Mockito.spy(chunk);
        doReturn(new NullTerrain(new Position(0,0))).when(chunkSpy).getTerrainAt(any(Position.class));

        controller = Mockito.mock(GameController.class);
        map = Mockito.mock(MapModel.class); when(map.thisChunk()).thenReturn(chunkSpy);
        when(controller.getMapModel()).thenReturn(map);
        when(controller.getInventoryModel()).thenReturn(inventorySpy);
    }

    @Test
    public void successfulUsage() {
        Tool tool = new Axe(10);
        tool.accept(new ItemVisitor(controller, new Position(1,1)));
        verify(mummySpy).reduceHealth(tool.getHitValue());
    }

    @Test
    public void successfulItemDrop() {
        Tool tool = new Axe(10);
        tool.accept(new ItemVisitor(controller, new Position(1,1)));

        tool.accept(new ItemVisitor(controller, new Position(1,1)));
        verify(mummySpy, Mockito.times(2)).reduceHealth(tool.getHitValue());
        verify(inventorySpy).add(mummySpy.getRandomDrop());
    }

    @Test
    public void failedUsage() {
        Tool tool = new Axe(10);
        tool.accept(new ItemVisitor(controller, new Position(0,0)));
        assertEquals(chunkSpy.getEntities().get(0), grass);
    }
}
