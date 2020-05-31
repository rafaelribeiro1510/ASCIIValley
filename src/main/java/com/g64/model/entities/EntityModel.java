package com.g64.model.entities;

import com.g64.model.MapModel;
import com.googlecode.lanterna.TextColor;
import com.g64.model.Position;
import com.g64.model.items.drops.Drop;

import java.util.Random;

public abstract class EntityModel extends Updatable{
    protected Position position;
    protected String string;
    protected TextColor color;
    protected boolean collision;
    protected Drop[] drops;
    protected int currentHealth;
    protected final int maxHealth;

    public EntityModel(Position position, String string, TextColor color, boolean collision, Drop[] drops, int maxHealth) {
        this.position = position;
        this.string = string;
        this.color = color;
        this.collision = collision;
        this.drops = drops;
        this.currentHealth = maxHealth;
        this.maxHealth = maxHealth;
    }

    public Position getPosition() { return position; }

    public void setPosition(Position position){ this.position = position; }

    public String getString() { return string; }

    public TextColor getColor() { return color; }

    public void setColor(TextColor color) { this.color = color; }

    public boolean hasCollision() { return collision; }

    public Drop getRandomDrop(){
        return drops[new Random().nextInt(drops.length)];
    }

    public void addHealth(int x){
        currentHealth += x;
        if (currentHealth > maxHealth) currentHealth = maxHealth;
    }

    public enum healthReduction{
        SURVIVED,
        DIED
    }
    public healthReduction reduceHealth(int x) {
        currentHealth -= x;
        if (currentHealth <= 0) return healthReduction.DIED;
        return healthReduction.SURVIVED;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void handleBoundaryCrossing(MapModel map){ }
}
