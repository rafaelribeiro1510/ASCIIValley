package com.g64.model;

import com.g64.controller.GameController;
import com.g64.model.entities.EntityModel;
import com.g64.model.entities.enemy.Enemy;
import com.g64.model.entities.enemy.EnemyFactory;
import com.g64.model.entities.enemy.Ghost;
import com.g64.model.entities.enemy.Mummy;
import com.g64.model.entities.plant.TallGrassEntity;
import com.g64.model.terrain.GrassTerrain;
import com.g64.model.terrain.MapTerrain;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;

public class EnemyTest {
    private GameController gameController;
    private ArrayList<MapTerrain> terrain;
    private ArrayList<EntityModel> entity;
    private ArrayList<Integer> neighbors;
    private ChunkModel chunkModel;

    @Before
    public void init() {

        terrain = new ArrayList<>(
                Arrays.asList(new GrassTerrain(new Position(0,0), 1))
        );

        entity = new ArrayList<>(
                Arrays.asList(new TallGrassEntity(new Position(0,0)))
        );

        neighbors = new ArrayList<>(); neighbors.add(2); neighbors.add(3); neighbors.add(4); neighbors.add(5);


        chunkModel = new ChunkModel(
                1, 1, 1, neighbors, terrain, entity);

        gameController = new GameController();
    }

    @Test
    public void enemyFactoryTest() {
        assertThat(EnemyFactory.generate(chunkModel), instanceOf(Enemy.class));
    }

}
