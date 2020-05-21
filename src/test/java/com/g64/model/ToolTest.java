package com.g64.model;

import com.g64.controller.GameController;
import com.g64.exceptions.Died;
import com.g64.model.entities.EntityModel;
import com.g64.model.entities.enemy.Mummy;
import com.g64.model.entities.plant.TallGrassEntity;
import com.g64.model.items.tools.Axe;
import com.g64.model.items.tools.Tool;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;

public class ToolTest {
    GameController controller;
    ChunkModel chunk;
    InventoryModel inventory = new InventoryModel();
    InventoryModel inventorySpy = Mockito.spy(inventory);


    TallGrassEntity grass = new TallGrassEntity(new Position(0,0));
    Mummy mummy = new Mummy(new Position(1,1));
    Mummy mummySpy = Mockito.spy(mummy);


    @SuppressWarnings("unchecked")
    @Before
    public void initChunk(){
        ArrayList<EntityModel> entities = new ArrayList<>(); entities.add(grass); entities.add(mummySpy);
        chunk = new ChunkModel(1, Mockito.mock(ArrayList.class), Mockito.mock(ArrayList.class), entities);
        controller = Mockito.mock(GameController.class);
        MapModel map = Mockito.mock(MapModel.class); Mockito.when(map.thisChunk()).thenReturn(chunk);
        Mockito.when(controller.getMapModel()).thenReturn(map);
        Mockito.when(controller.getInventoryModel()).thenReturn(inventorySpy);
    }

    @Test
    public void successfulUsage() throws Died {
        Tool tool = new Axe();
        tool.use(controller, new Position(1,1));
        verify(mummySpy).reduceHealth(tool.getHitValue());
    }

    @Test
    public void successfulItemDrop() throws Died {
        Tool tool = new Axe();
        tool.use(controller, new Position(1,1));

        tool.use(controller, new Position(1,1));
        verify(mummySpy, Mockito.times(2)).reduceHealth(tool.getHitValue());
        verify(inventorySpy).add(mummySpy.getRandomDrop());
    }

    @Test
    public void failedUsage() {
        Tool tool = new Axe();
        tool.use(controller, new Position(0,0));
        assertEquals(chunk.getEntityAt(new Position(0,0)), grass);
    }
}
