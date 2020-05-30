package com.g64.model.items.tools;

import com.g64.model.entities.visitors.TargetVisitor;

public class Hoe extends Tool {
    public Hoe(int durability){
        this.name = "HOE";
        this.durability = durability;
    }

    @Override
    public usageValue accept(TargetVisitor targetVisitor) {
        return targetVisitor.allowUsage(this);
    }
}
