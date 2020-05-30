package com.g64.model.items.tools;

import com.g64.model.entities.visitors.TargetVisitor;

public class WateringCan extends Tool{
    public WateringCan(int durability) {
        this.name = "CAN";
        this.durability = durability;
        this.hitValue = 60;
    }

    @Override
    public itemValue accept(TargetVisitor targetVisitor) {
        return targetVisitor.allowUsage(this);
    }
}
