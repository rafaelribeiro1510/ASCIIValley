package com.g64.model.items.tools;

import com.g64.exceptions.Broke;
import com.g64.model.items.Item;

public abstract class Tool extends Item {
    protected int durability;
    protected int hitValue;

    public void decrementValue() throws Broke {
        durability--;
        if (durability <= 0) throw new Broke();
    }

    public int getValue() { return durability; }

    public int getHitValue() { return hitValue; }
}
