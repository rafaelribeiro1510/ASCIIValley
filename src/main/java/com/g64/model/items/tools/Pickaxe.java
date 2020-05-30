package com.g64.model.items.tools;

import com.g64.model.entities.visitors.TargetVisitor;

public class Pickaxe extends Tool {
    public Pickaxe(int durability){
        this.name = "PICK";
        this.durability = durability;
        this.hitValue = 5;
    }

    @Override
    public itemValue accept(TargetVisitor targetVisitor) {
        return targetVisitor.allowUsage(this);
    }
}
