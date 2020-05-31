package com.g64.model.terrain;

import com.googlecode.lanterna.TextColor;
import com.g64.model.Position;

public class PlanksTerrain extends MapTerrain{
    public PlanksTerrain(Position position, Integer id){
        super(position, new TextColor.RGB(46,27,7), id);
    }
}
