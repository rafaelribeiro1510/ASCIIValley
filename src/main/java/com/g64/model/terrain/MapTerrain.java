package com.g64.model.terrain;

import com.googlecode.lanterna.TextColor;
import com.g64.model.Position;

public abstract class MapTerrain {
    private Position position;
    private TextColor color;

    public MapTerrain(Position position, TextColor color) {
        this.position = position;
        this.color = color;
    }

    public TextColor getColor() {
        return color;
    }

    public Position getPosition() { return this.position; }

}
