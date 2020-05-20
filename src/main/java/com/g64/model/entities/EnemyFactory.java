package com.g64.model.entities;

import com.g64.controller.GameController;
import com.g64.model.ChunkModel;
import com.g64.model.Position;
import com.g64.model.entities.map.NullEntity;

import java.util.Random;

public class EnemyFactory {
    public static final int NUMBER_ENEMIES = 5;

    public static void generate(ChunkModel chunk){
        int n = 0;
        while(n < NUMBER_ENEMIES){
            Position target = new Position(new Random().nextInt(GameController.MAP_WIDTH), new Random().nextInt(GameController.MAP_HEIGHT));
            if (chunk.getEntityAt(target) instanceof NullEntity) { chunk.getEntities().add(new Mummy(target)); n++; }
        }
    }
}
