package com.g64.model;

import com.g64.controller.GameController;
import com.g64.controller.commands.*;
import com.g64.model.entities.EntityModel;
import com.g64.model.entities.Player;
import com.g64.model.entities.enemy.Enemy;
import com.g64.model.entities.enemy.EnemyFactory;
import com.g64.model.entities.enemy.Ghost;
import com.g64.model.entities.enemy.Mummy;
import com.g64.model.entities.enemy.humours.GhostAggroed;
import com.g64.model.entities.plant.TallGrassEntity;
import com.g64.model.terrain.GrassTerrain;
import com.g64.model.terrain.MapTerrain;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class EnemyTest {
    private GameController controller;
    private MapModel map;
    private ChunkModel chunk;
    private Player player;

    @SuppressWarnings("unchecked")
    @Before
    public void init() {

        ArrayList<MapTerrain> terrain = new ArrayList<>(
                Arrays.asList(
                        new GrassTerrain(new Position(0,0), 1),
                        new GrassTerrain(new Position(0,1), 1),
                        new GrassTerrain(new Position(1,0), 1),
                        new GrassTerrain(new Position(1,1), 1))
        );

        chunk = new ChunkModel(
                2, 2, 1, Mockito.mock(ArrayList.class), terrain, Mockito.mock(ArrayList.class));

        player = new Player(new Position(10,10));
        controller = Mockito.mock(GameController.class);
        map = Mockito.mock(MapModel.class); when(map.thisChunk()).thenReturn(chunk);
        when(controller.getMapModel()).thenReturn(map);
        when(controller.getPlayer()).thenReturn(player);
    }

    @Test
    public void enemyFactoryTest() {
        assertThat(EnemyFactory.generate(chunk), instanceOf(Enemy.class));
    }


    @Test
    public void testMummyAggroing(){
        Mummy mummy = new Mummy(new Position(0,0));
        assertEquals(mummy.getActiveHumour(), mummy.getNormalHumour());

        player.setPosition(new Position(1,0));
        mummy.updateState(player.getPosition());
        assertEquals(mummy.getActiveHumour(), mummy.getAggroedHumour());

        player.setPosition(new Position(10,10));
        mummy.updateState(player.getPosition());
        assertEquals(mummy.getActiveHumour(), mummy.getNormalHumour());
    }

    @Test
    public void testGhostAggroing(){
        Ghost ghost = new Ghost(new Position(0,0));
        assertEquals(ghost.getActiveHumour(), ghost.getNormalHumour());

        player.setPosition(new Position(1,0));
        ghost.updateState(player.getPosition());
        assertEquals(ghost.getActiveHumour(), ghost.getAggroedHumour());

        player.setPosition(new Position(10,10));
        ghost.updateState(player.getPosition());
        assertEquals(ghost.getActiveHumour(), ghost.getNormalHumour());
    }

    @Test
    public void testAggroMovement(){
        Mummy enemy = new Mummy(new Position(0,0));

        player.setPosition(new Position(2,0));
        enemy.updateState(player.getPosition());
        enemy.setMovementCooldown(0);
        assertTrue(enemy.update(controller) instanceof MoveRight);


        player.setPosition(new Position(-2,0));
        enemy.updateState(player.getPosition());
        enemy.setMovementCooldown(0);
        assertTrue(enemy.update(controller) instanceof MoveLeft);


        player.setPosition(new Position(0,2));
        enemy.updateState(player.getPosition());
        enemy.setMovementCooldown(0);
        assertTrue(enemy.update(controller) instanceof MoveDown);


        player.setPosition(new Position(0,-2));
        enemy.updateState(player.getPosition());
        enemy.setMovementCooldown(0);
        assertTrue(enemy.update(controller) instanceof MoveUp);


        player.setPosition(new Position(1,0));
        enemy.updateState(player.getPosition());
        enemy.setMovementCooldown(0);
        assertTrue(enemy.update(controller) instanceof AttackPlayer);
    }

    @Test
    public void testNormalMovement(){
        Mummy enemy = new Mummy(new Position(0,0));

        player.setPosition(new Position(10,0));
        enemy.updateState(player.getPosition());
        enemy.setMovementCooldown(0);
        Command enemyAction = enemy.update(controller);
        assertTrue(enemyAction instanceof MoveRight || enemyAction instanceof MoveUp || enemyAction instanceof MoveLeft || enemyAction instanceof MoveDown);

    }
}
