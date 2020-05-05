package model;

import com.googlecode.lanterna.TextColor;

public abstract class EntityModel {
    protected Position position;
    protected String string;
    protected TextColor color;
    protected boolean collision;

    public EntityModel(Position position, String string, TextColor color, boolean collision) {
        this.position = position;
        this.string = string;
        this.color = color;
        this.collision = collision;
    }

    public Position getPosition() { return position; }

    public void setPosition(Position position){ this.position = position; }

    public String getString() { return string; }

    public TextColor getColor() { return color; }

    public boolean hasCollision() { return collision; }
}
