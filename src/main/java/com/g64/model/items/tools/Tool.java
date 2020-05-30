package com.g64.model.items.tools;

import com.g64.model.items.Item;

public abstract class Tool implements Item {
    protected String name;
    protected int durability;
    protected int hitValue;

    public String getName(){ return this.name; }

    public itemValue decrementValue() {
        durability--;
        if (durability <= 0) return itemValue.BROKEN;
        return itemValue.NOT_BROKEN;
    }

    public int getValue() { return durability; }

    public int getHitValue() { return hitValue; }
}
