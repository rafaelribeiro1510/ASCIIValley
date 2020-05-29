package com.g64.model.items.tools;

import com.g64.exceptions.RemoveFromInventory;
import com.g64.model.entities.visitors.TargetVisitor;

public class WateringCan extends Tool{
    public WateringCan(int durability) {
        this.name = "CAN";
        this.durability = durability;
        this.hitValue = 60;
    }

    @Override
    public void accept(TargetVisitor targetVisitor) throws RemoveFromInventory {
        targetVisitor.allowUsage(this);
    }
}
