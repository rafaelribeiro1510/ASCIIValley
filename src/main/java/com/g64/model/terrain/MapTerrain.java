package com.g64.model.terrain;

import com.g64.model.Position;
import com.googlecode.lanterna.TextColor;

public abstract class MapTerrain {
    private Position position;
    private TextColor color;
    private Integer id;

    public MapTerrain(Position position, TextColor color, Integer id) {
        this.position = position;
        this.color = color;
        this.id = id;
    }

    public TextColor getColor() {
        return color;
    }

    public Position getPosition() { return this.position; }

    public Integer getId() { return id; }
}
