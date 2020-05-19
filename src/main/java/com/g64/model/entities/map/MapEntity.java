package com.g64.model.entities.map;

import com.googlecode.lanterna.TextColor;
import com.g64.model.Position;
import com.g64.model.entities.EntityModel;
import com.g64.model.items.drops.*;

public abstract class MapEntity extends EntityModel {
    public MapEntity(Position position, String string, TextColor color, boolean collision, Drop[] drops, int maxHealth) {
        super(position, string, color, collision, drops, maxHealth);
    }
}
