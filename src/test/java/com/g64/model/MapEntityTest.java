package com.g64.model;

import com.g64.model.entities.map.*;
import com.g64.model.entities.plant.GrownCarrotEntity;
import com.g64.model.entities.plant.GrownCornEntity;
import com.g64.model.entities.plant.TallGrassEntity;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MapEntityTest {
    Position position;

    @Before
    public void init(){
        position = new Position(0,0);
    }

    @Test
    public void testFactory(){
        MapEntity rock = MapEntityFactory.get(position, "^");
        MapEntity grass = MapEntityFactory.get(position, "y");
        MapEntity water = MapEntityFactory.get(position, "~");
        MapEntity tree = MapEntityFactory.get(position, "O");
        MapEntity wall = MapEntityFactory.get(position, "#");
        MapEntity carrot = MapEntityFactory.get(position, "j");
        MapEntity corn = MapEntityFactory.get(position, "i");
        assertTrue(rock instanceof RockEntity);
        assertTrue(grass instanceof TallGrassEntity);
        assertTrue(water instanceof WaterEntity);
        assertTrue(tree instanceof TreeEntity);
        assertTrue(wall instanceof UnpassableWallEntity);
        assertTrue(carrot instanceof GrownCarrotEntity);
        assertTrue(corn instanceof GrownCornEntity);
    }
}
