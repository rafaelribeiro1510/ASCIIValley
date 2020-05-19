package com.g64.model.terrain;

import com.googlecode.lanterna.TextColor;
import com.g64.model.Position;

public class NullTerrain extends MapTerrain {
    public NullTerrain(Position position){
        super(position, new TextColor.RGB(255,255,255));
    }
}
