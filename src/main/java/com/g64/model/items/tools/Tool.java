package com.g64.model.items.tools;

import com.g64.exceptions.RemoveFromInventory;
import com.g64.model.items.Item;

public abstract class Tool implements Item {
    protected String name;
    protected int durability;
    protected int hitValue;

    public String getName(){ return this.name; }

    public void decrementValue() throws RemoveFromInventory {
        durability--;
        if (durability <= 0) throw new RemoveFromInventory();
    }

    public int getValue() { return durability; }

    public void setValue(int value) { this.durability = value; }

    public int getHitValue() { return hitValue; }
}
