package com.g64.model.entities.map;

import com.g64.model.Position;
import com.googlecode.lanterna.TextColor;

public class InvisibleWallEntity extends MapEntity {
    public InvisibleWallEntity(Position position) {
        super(position, " ", new TextColor.RGB(0,0,0), true, null, 999);
    }
}
