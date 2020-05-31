package com.g64.model.entities.map;

import com.g64.model.Position;
import com.g64.model.items.drops.Drop;
import com.g64.model.items.drops.RockDrop;
import com.googlecode.lanterna.TextColor;

public class RockEntity extends MapEntity {
    public RockEntity(Position position) {
        super(position, "^", new TextColor.RGB(40,40,40), true, new Drop[] {new RockDrop()}, 10);
    }
}
