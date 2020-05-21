package com.g64.model.entities.plant;

import com.g64.model.items.drops.SeedDropFactory;
import com.googlecode.lanterna.TextColor;
import com.g64.model.Position;
import com.g64.model.items.drops.Drop;
import com.g64.model.items.drops.TallGrassDrop;

public class TallGrassEntity extends PlantEntity {
    public TallGrassEntity(Position position){
        super(position, "y", new TextColor.RGB(0, 204, 0), false, new Drop[] {SeedDropFactory.getRandomSeed(), new TallGrassDrop()}, 1);
    }
}
