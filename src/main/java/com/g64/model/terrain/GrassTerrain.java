package com.g64.model.terrain;

import com.g64.model.Position;
import com.googlecode.lanterna.TextColor;

public class GrassTerrain extends MapTerrain {
    public GrassTerrain(Position position, Integer id){
        super(position, new TextColor.RGB(0, 102, 0), id);
    }
}
