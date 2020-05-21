package com.g64.model.entities.plant;

import com.g64.model.Position;
import com.g64.model.entities.EntityModel;
import com.g64.model.items.drops.Drop;
import com.g64.model.items.drops.GrownCarrotDrop;
import com.googlecode.lanterna.TextColor;

public class GrownCarrotEntity extends PlantEntity {
    public GrownCarrotEntity(Position position) {
        super(position, "j", new TextColor.RGB(182, 69, 0), false, new Drop[] {new GrownCarrotDrop()}, 1);
    }
}
