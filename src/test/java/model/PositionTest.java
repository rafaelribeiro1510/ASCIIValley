package model;

import Exceptions.CrossedEast;
import Exceptions.CrossedNorth;
import Exceptions.CrossedSouth;
import Exceptions.CrossedWest;
import com.googlecode.lanterna.TerminalSize;
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
        this.position.down();
        assertEquals(2, this.position.getY());
        this.position.up();
        assertEquals(1, this.position.getY());
        this.position.right();
        assertEquals(2, this.position.getX());
        this.position.left();
        assertEquals(1, this.position.getX());
    }

    @Test
    public void crossedNorth() throws CrossedNorth {
        thrown.expect(CrossedNorth.class);
        this.position.up();
        this.position.checkUp(height);
    }

    @Test
    public void crossedSouth() throws CrossedSouth {
        thrown.expect(CrossedSouth.class);
        this.position.down();
        this.position.checkDown(height);
    }

    @Test
    public void crossedEast() throws CrossedEast {
        thrown.expect(CrossedEast.class);
        this.position.right();
        this.position.checkRight(width);
    }

    @Test
    public void crossedWest() throws CrossedWest {
        thrown.expect(CrossedWest.class);
        this.position.left();
        this.position.checkLeft(width);
    }
}
