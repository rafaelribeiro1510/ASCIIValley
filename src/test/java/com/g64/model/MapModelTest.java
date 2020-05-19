package com.g64.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MapModelTest {
    private MapModel mp;

    @Before
    public void checkReadMap() {
        String relativePathname = "resources/chunks.csv";
        mp = new MapModel(1, relativePathname);
    }

    @Test
    public void checkSuccessfulMove(){
        mp.moveEast();
        assertEquals(3, mp.getId());
    }

    @Test
    public void checkFailedMove(){
        mp.moveSouth();
        assertEquals(1, mp.getId());
        mp.moveNorth();
        assertEquals(1, mp.getId());
        mp.moveWest();
        assertEquals(1, mp.getId());
    }
}
