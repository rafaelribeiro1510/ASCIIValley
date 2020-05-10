package model.items.tools;

import model.items.Item;

public abstract class Tool extends Item {
    protected int durability;
    protected int hitValue;

    public void decrementDurability(){ if (durability > 0) durability--; }

    public int getValue() { return durability; }
}
