package com.g64.model.terrain;

import com.g64.model.Position;
import com.googlecode.lanterna.TextColor;

public class StoneTerrain extends MapTerrain {
    public StoneTerrain(Position position, Integer id){
        super(position, new TextColor.RGB(105, 105, 105), id);
    }
}
