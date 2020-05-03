package controller;

import controller.action.*;
import model.Position;
import org.junit.Before;
import org.junit.Test;

import static controller.GameController.MAP_HEIGHT;
import static controller.GameController.MAP_WIDTH;
import static org.junit.Assert.assertEquals;


public class actionEventTest {
    private GameController gc;
    private ActionEvent event;
    private Position chunk1RightBorder = new Position(MAP_WIDTH - 1, 10);

    @Before
    public void initGameController() {
        gc = new GameController();
    }

    @Test
    public void actionRightNewChunk() {
        gc.getPlayer().setPosition(chunk1RightBorder);
        event = new MoveRight(gc, gc.getMapModel());
        gc.processKey(event);

        assertEquals(0, gc.getPlayer().getPosition().getX());
        assertEquals(10, gc.getPlayer().getPosition().getY());
    }

    @Test
    public void actionUpStoneCollision() {
        gc.getPlayer().setPosition(chunk1RightBorder);
        event = new MoveUp(gc, gc.getMapModel());
        gc.processKey(event);

        assertEquals(MAP_WIDTH - 1, gc.getPlayer().getPosition().getX());
        assertEquals(10, gc.getPlayer().getPosition().getY());
    }

    @Test
    public void actionDownWaterCollision() {
        gc.getPlayer().setPosition(chunk1RightBorder);
        event = new MoveDown(gc, gc.getMapModel());
        gc.processKey(event);
        gc.processKey(event);

        assertEquals(MAP_WIDTH - 1, gc.getPlayer().getPosition().getX());
        assertEquals(11, gc.getPlayer().getPosition().getY());
    }

}
