package model.entities;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import model.Position;

public abstract class EntityModel {
    protected Position position;
    protected String string;
    protected TextColor color;

    public EntityModel(Position position, String string, TextColor color) {
        this.position = position;
        this.string = string;
        this.color = color;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getString() { return string; }

    public TextColor getColor() { return color; }

}
