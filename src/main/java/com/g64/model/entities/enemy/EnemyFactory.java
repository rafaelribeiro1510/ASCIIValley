package com.g64.model.entities.enemy;

import com.g64.model.ChunkModel;
import com.g64.model.Position;

import java.util.Random;

public class EnemyFactory {
    public static final int NUMBER_ENEMIES = 5;

    public static Enemy generate(ChunkModel chunk){
        Position target = new Position(new Random().nextInt(chunk.getWidth()), new Random().nextInt(chunk.getHeight()));
        Enemy[] enemies = {new Mummy(target), new Ghost(target)};
        return enemies[new Random().nextInt(enemies.length)];
    }
}
