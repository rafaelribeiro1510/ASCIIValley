package model.entities;

import controller.GameController;
import model.ChunkModel;
import model.Position;
import model.entities.map.NullEntity;

import java.util.Random;

public class EnemyFactory {
    public static final int NUMBER_ENEMIES = 5;

    public static void generate(ChunkModel chunk){
        int n = 0;
        while(n < NUMBER_ENEMIES){
            Position target = new Position(new Random().nextInt(GameController.MAP_WIDTH), new Random().nextInt(GameController.MAP_HEIGHT));
            if (chunk.getEntityAt(target).getClass() == NullEntity.class) { chunk.getEntities().add(new Mummy(target)); n++; }
        }
    }
}
