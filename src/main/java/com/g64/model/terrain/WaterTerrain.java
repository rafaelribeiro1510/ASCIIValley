package com.g64.model.terrain;

import com.g64.model.Position;
import com.googlecode.lanterna.TextColor;

public class WaterTerrain extends MapTerrain {
    public WaterTerrain(Position position, Integer id){
        super(position, new TextColor.RGB(0, 153, 255), id);
    }
}
