package com.g64.model.terrain;

import com.googlecode.lanterna.TextColor;
import com.g64.model.Position;

public class GrassTerrain extends MapTerrain {
    public GrassTerrain(Position position){
        super(position, new TextColor.RGB(0, 102, 0));
    }
}
