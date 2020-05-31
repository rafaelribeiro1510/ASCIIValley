package com.g64.model.terrain;

import com.googlecode.lanterna.TextColor;
import com.g64.model.Position;

public class SoilTerrain extends MapTerrain {
    public SoilTerrain(Position position, Integer id){
        super(position, new TextColor.RGB(102, 51, 0), id);
    }
}
