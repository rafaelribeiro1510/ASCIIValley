package com.g64.model.terrain;

import com.googlecode.lanterna.TextColor;
import com.g64.model.Position;

public class StoneTerrain extends MapTerrain {
    public StoneTerrain(Position position, Integer id){
        super(position, new TextColor.RGB(105, 105, 105), id);
    }
}
