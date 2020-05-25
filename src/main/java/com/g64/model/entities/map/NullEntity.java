package com.g64.model.entities.map;

import com.googlecode.lanterna.TextColor;
import com.g64.model.Position;

public class NullEntity extends MapEntity {
    public NullEntity(Position position){
        super(position, " ", new TextColor.RGB(0,0,0), false, null, 1);
    }
}
