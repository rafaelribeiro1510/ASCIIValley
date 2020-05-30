package com.g64.model.items.tools;

import com.g64.model.items.Item;

public abstract class Tool implements Item {
    protected String name;
    protected int durability;
    protected int hitValue;

    public String getName(){ return this.name; }

    public usageValue decrementValue() {
        durability--;
        if (durability <= 0) return usageValue.BROKEN;
        return usageValue.NOT_BROKEN;
    }

    public int getValue() { return durability; }

    public int getHitValue() { return hitValue; }
}
