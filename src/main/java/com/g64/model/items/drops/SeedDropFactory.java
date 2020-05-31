package com.g64.model.items.drops;

import java.util.Random;

public class SeedDropFactory {
    public static SeedDrop getRandomSeed(){
        SeedDrop[] seeds = {new CornSeedDrop(), new CarrotSeedDrop()};
        return seeds[new Random().nextInt(seeds.length)];
    }
}
