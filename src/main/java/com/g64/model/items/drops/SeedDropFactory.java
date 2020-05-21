package com.g64.model.items.drops;

import java.util.Random;

public class SeedDropFactory {
    public static SeedDrop getRandomSeed(){
        switch (new Random().nextInt(2)){
            case 0:
                return new CornSeedDrop();
            case 1:
                return new CarrotSeedDrop();
        }
        return null;
    }
}
