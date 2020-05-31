package com.g64.model.terrain;

import com.g64.model.Position;
import com.googlecode.lanterna.TextColor;

public class SoilTerrain extends MapTerrain {
    public SoilTerrain(Position position, Integer id){
        super(position, new TextColor.RGB(102, 51, 0), id);
    }
}
