package com.g64.model.terrain;

import com.g64.model.Position;
import com.googlecode.lanterna.TextColor;

public class NullTerrain extends MapTerrain {
    public NullTerrain(Position position){
        super(position, new TextColor.RGB(255,255,255), 0);
    }
}
