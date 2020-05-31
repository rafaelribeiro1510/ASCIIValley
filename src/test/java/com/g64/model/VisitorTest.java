package com.g64.model;

import com.g64.controller.GameController;
import com.g64.model.entities.EntityModel;
import com.g64.model.entities.map.RockEntity;
import com.g64.model.entities.map.TreeEntity;
import com.g64.model.entities.plant.CarrotSeedEntity;
import com.g64.model.entities.plant.TallGrassEntity;
import com.g64.model.entities.visitors.ItemVisitor;
import com.g64.model.items.Item;
import com.g64.model.items.drops.*;
import com.g64.model.items.tools.*;
import com.g64.model.terrain.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

public class VisitorTest {
    GameController controller;
    InventoryModel inventory;
    MapModel map;
    ChunkModel chunk;


    @SuppressWarnings("unchecked")
    @Before
    public void initChunk(){

        ArrayList<EntityModel> entities = new ArrayList<>();
            entities.add(new TallGrassEntity(new Position(0,0)));
            entities.add(new CarrotSeedEntity(new Position(0,1)));
            entities.add(new TreeEntity(new Position(1,0)));
            entities.add(new RockEntity(new Position(1,1)));
        ArrayList<MapTerrain> terrain = new ArrayList<>();
            terrain.add(new GrassTerrain(new Position(0,0), 1));
            terrain.add(new GrassTerrain(new Position(1,0), 1));
            terrain.add(new GrassTerrain(new Position(2,0), 1 ));
            terrain.add(new SoilTerrain(new Position(0,1), 1));
            terrain.add(new SoilTerrain(new Position(2,1), 1));
            terrain.add(new StoneTerrain(new Position(1,1), 1));
        ChunkModel chunk = new ChunkModel(3,3,1, Mockito.mock(ArrayList.class), terrain, entities);
        this.chunk = Mockito.spy(chunk);

        inventory = new InventoryModel();

        controller = Mockito.mock(GameController.class);
        map = Mockito.mock(MapModel.class); when(map.thisChunk()).thenReturn(this.chunk);
        when(controller.getMapModel()).thenReturn(map);
        when(controller.getInventoryModel()).thenReturn(inventory);
    }

    @Test
    public void axeWork(){
        Tool tool = new Axe(10);
        assertNotEquals(tool.accept(new ItemVisitor(controller, new Position(1,0))), Item.usageValue.UNUSED);
    }

    @Test
    public void axeDoesntWork(){
        Tool tool = new Axe(10);
        assertEquals(tool.accept(new ItemVisitor(controller, new Position(0,0))), Item.usageValue.UNUSED);
    }

    @Test
    public void hoeWork(){
        Tool tool = new Hoe(10);
        assertNotEquals(tool.accept(new ItemVisitor(controller, new Position(2,0))), Item.usageValue.UNUSED);
    }

    @Test
    public void hoeDoesntWork(){
        Tool tool = new Hoe(10);
        assertEquals(tool.accept(new ItemVisitor(controller, new Position(1,1))), Item.usageValue.UNUSED);
    }

    @Test
    public void scytheWork(){
        Tool tool = new Scythe(10);
        assertNotEquals(tool.accept(new ItemVisitor(controller, new Position(0,0))), Item.usageValue.UNUSED);
    }

    @Test
    public void scytheDoesntWork(){
        Tool tool = new Scythe(10);
        assertEquals(tool.accept(new ItemVisitor(controller, new Position(1,0))), Item.usageValue.UNUSED);
    }

    @Test
    public void pickWork(){
        Tool tool = new Pickaxe(10);
        assertNotEquals(tool.accept(new ItemVisitor(controller, new Position(1,1))), Item.usageValue.UNUSED);
    }

    @Test
    public void pickDoesntWork(){
        Tool tool = new Pickaxe(10);
        assertEquals(tool.accept(new ItemVisitor(controller, new Position(0,1))), Item.usageValue.UNUSED);
    }

    @Test
    public void canWork(){
        Tool tool = new WateringCan(10);
        assertNotEquals(tool.accept(new ItemVisitor(controller, new Position(0,1))), Item.usageValue.UNUSED);
    }

    @Test
    public void canDoesntWork(){
        Tool tool = new WateringCan(10);
        assertEquals(tool.accept(new ItemVisitor(controller, new Position(2,0))), Item.usageValue.UNUSED);
    }


    @Test
    public void seedWork(){
        Drop drop = new CarrotSeedDrop();
        assertNotEquals(drop.accept(new ItemVisitor(controller, new Position(2,1))), Item.usageValue.UNUSED);
    }

    @Test
    public void seedDoesntWork(){
        Drop drop = new CarrotSeedDrop();
        assertEquals(drop.accept(new ItemVisitor(controller, new Position(1,1))), Item.usageValue.UNUSED);
    }

    @Test
    public void logWork(){
        Drop drop = new LogDrop();
        assertNotEquals(drop.accept(new ItemVisitor(controller, new Position(2,0))), Item.usageValue.UNUSED);
    }

    @Test
    public void logDoesntWork(){
        Drop drop = new LogDrop();
        assertEquals(drop.accept(new ItemVisitor(controller, new Position(2,1))), Item.usageValue.UNUSED);
    }

    @Test
    public void rockWork(){
        Drop drop = new RockDrop();
        assertNotEquals(drop.accept(new ItemVisitor(controller, new Position(2,0))), Item.usageValue.UNUSED);
    }

    @Test
    public void rockDoesntWork(){
        Drop drop = new RockDrop();
        assertEquals(drop.accept(new ItemVisitor(controller, new Position(0,0))), Item.usageValue.UNUSED);
    }

    @Test
    public void tallGrassWork(){
        Drop drop = new TallGrassDrop();
        assertNotEquals(drop.accept(new ItemVisitor(controller, new Position(2,0))), Item.usageValue.UNUSED);
    }

    @Test
    public void tallDoesntGrassWork(){
        Drop drop = new TallGrassDrop();
        assertEquals(drop.accept(new ItemVisitor(controller, new Position(2,1))), Item.usageValue.UNUSED);
    }
}
