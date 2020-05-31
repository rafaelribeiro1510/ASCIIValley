package com.g64.model.entities.map;

import com.g64.model.Position;
import com.googlecode.lanterna.TextColor;

public class NullEntity extends MapEntity {
    public NullEntity(Position position){
        super(position, " ", new TextColor.RGB(0,0,0), false, null, 1);
    }
}
