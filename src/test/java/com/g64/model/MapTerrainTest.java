package com.g64.model;

import com.g64.model.terrain.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class MapTerrainTest {
    Position position;

    @Before
    public void init() {
        position = new Position(0, 0);
    }

    @Test
    public void testFactory() {
        MapTerrain grass = MapTerrainFactory.get(position, 1);
        MapTerrain sand = MapTerrainFactory.get(position, 2);
        MapTerrain soil = MapTerrainFactory.get(position, 3);
        MapTerrain water = MapTerrainFactory.get(position, 4);
        MapTerrain stone = MapTerrainFactory.get(position, 5);
        MapTerrain planks = MapTerrainFactory.get(position, 6);
        assertTrue(grass instanceof GrassTerrain);
        assertTrue(sand instanceof SandTerrain);
        assertTrue(soil instanceof SoilTerrain);
        assertTrue(water instanceof WaterTerrain);
        assertTrue(stone instanceof StoneTerrain);
        assertTrue(planks instanceof PlanksTerrain);
    }
}
