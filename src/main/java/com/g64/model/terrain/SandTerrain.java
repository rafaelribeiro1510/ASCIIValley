package com.g64.model.terrain;

import com.g64.model.Position;
import com.googlecode.lanterna.TextColor;

public class SandTerrain extends MapTerrain {
    public SandTerrain(Position position, Integer id){
        super(position, new TextColor.RGB(204, 153, 0), id);
    }
}
