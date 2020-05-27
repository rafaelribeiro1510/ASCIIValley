package com.g64.model;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class PositionTest {
    private Position position;
    private int width;
    private int height;

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Before
    public void initialize(){
        position = new Position(1, 1);
        width = 2;
        height = 2;
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
    public void crossedNorth() throws CrossedUp {
        thrown.expect(CrossedUp.class);
        this.position.moveUp();
        this.position.checkUp(height);
    }

    @Test
    public void crossedSouth() throws CrossedDown {
        thrown.expect(CrossedDown.class);
        this.position.moveDown();
        this.position.checkDown(height);
    }

    @Test
    public void crossedEast() throws CrossedRight {
        thrown.expect(CrossedRight.class);
        this.position.moveRight();
        this.position.checkRight(width);
    }

    @Test
    public void crossedWest() throws CrossedLeft {
        thrown.expect(CrossedLeft.class);
        this.position.moveLeft();
        this.position.checkLeft(width);
    }

    @Test
    public void distanceTest() {
        Position otherPosition = new Position(0,0);
        assertEquals(position.distanceTo(otherPosition), Math.sqrt(2), 0.001);
    }
}
