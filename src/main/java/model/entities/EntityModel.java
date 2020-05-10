package model.entities;

import com.googlecode.lanterna.TextColor;
import model.Position;
import model.items.drops.Drop;

import java.util.Random;

public abstract class EntityModel {
    protected Position position;
    protected String string;
    protected TextColor color;
    protected boolean collision;
    protected Drop[] drops;

    public EntityModel(Position position, String string, TextColor color, boolean collision, Drop[] drops) {
        this.position = position;
        this.string = string;
        this.color = color;
        this.collision = collision;
        this.drops = drops;
    }

    public Position getPosition() { return position; }

    public void setPosition(Position position){ this.position = position; }

    public String getString() { return string; }

    public TextColor getColor() { return color; }

    public boolean hasCollision() { return collision; }

    public Drop getRandomDrop(){
        return drops[new Random().nextInt(drops.length)];
    }
}
