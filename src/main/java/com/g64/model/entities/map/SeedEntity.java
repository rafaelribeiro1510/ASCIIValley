package com.g64.model.entities.map;

import com.googlecode.lanterna.TextColor;
import com.g64.model.Position;
import com.g64.model.items.drops.Drop;
import com.g64.model.items.drops.SeedDrop;

public class SeedEntity extends PlantEntity {
    public SeedEntity(Position position){
        super(position, ":", new TextColor.RGB(26, 12, 0), false, new Drop[] {new SeedDrop()}, 1);
    }
}
