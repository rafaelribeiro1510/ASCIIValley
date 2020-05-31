package com.g64.model.entities.map;

import com.g64.model.Position;
import com.googlecode.lanterna.TextColor;

public class UnpassableWallEntity extends MapEntity {
    public UnpassableWallEntity(Position position) {
        super(position, "#", new TextColor.RGB(0,0,0), true, null, 999);
    }
}
