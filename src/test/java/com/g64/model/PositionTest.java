package com.g64.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PositionTest {
    private Position position;

    @Before
    public void initialize(){
        position = new Position(1, 1);
    }

    @Test
    public void testMovements(){
        this.position.moveDown();
        assertEquals(2, this.position.getY());
        this.position.moveUp();
        assertEquals(1, this.position.getY());
        this.position.moveRight();
        assertEquals(2, this.position.getX());
        this.position.moveLeft();
        assertEquals(1, this.position.getX());
    }

    @Test
    public void distanceTest() {
        Position otherPosition = new Position(0,0);
        assertEquals(position.distanceTo(otherPosition), Math.sqrt(2), 0.001);
    }
}
