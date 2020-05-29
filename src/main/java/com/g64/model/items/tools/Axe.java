package com.g64.model.items.tools;

import com.g64.exceptions.RemoveFromInventory;
import com.g64.model.entities.visitors.TargetVisitor;

public class Axe extends Tool {
    public Axe(int durability) {
        this.name = "AXE";
        this.durability = durability;
        this.hitValue = 5;
    }

    @Override
    public void accept(TargetVisitor targetVisitor) throws RemoveFromInventory {
        targetVisitor.allowUsage(this);
    }

}