package com.g64.model.items.tools;

import com.g64.exceptions.RemoveFromInventory;
import com.g64.model.entities.target.Target;

public class Axe extends Tool {
    public Axe() {
        this.name = "AXE";
        this.durability = 100;
        this.hitValue = 5;
    }

    @Override
    public void accept(Target target) throws RemoveFromInventory {
        target.allowUsage(this);
    }

}