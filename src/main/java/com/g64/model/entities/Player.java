package com.g64.model.entities;

import com.googlecode.lanterna.TextColor;
import com.g64.model.Position;

public class Player extends EntityModel {
    public Player(Position position, String string, TextColor color) {
        super(position, string, color, true, null, 40);
    }
}
