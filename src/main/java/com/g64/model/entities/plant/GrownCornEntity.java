package com.g64.model.entities.plant;

import com.g64.model.Position;
import com.g64.model.items.drops.GrownCornDrop;
import com.g64.model.items.drops.Drop;
import com.googlecode.lanterna.TextColor;

public class GrownCornEntity extends PlantEntity {
    public GrownCornEntity(Position position) {
        super(position, "i", new TextColor.RGB(182, 143, 0), false, new Drop[] {new GrownCornDrop()}, 1);
    }
}
