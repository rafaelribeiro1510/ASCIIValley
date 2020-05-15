package model.items.tools;

import exceptions.Broke;
import model.items.Item;

public abstract class Tool extends Item {
    protected int durability;
    protected int hitValue;

    public void decrementDurability() throws Broke {
        durability--;
        if (durability <= 0) throw new Broke();
    }

    public int getValue() { return durability; }
}
