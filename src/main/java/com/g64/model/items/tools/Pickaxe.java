package com.g64.model.items.tools;

import com.g64.exceptions.RemoveFromInventory;
import com.g64.model.entities.visitors.TargetVisitor;

public class Pickaxe extends Tool {
    public Pickaxe(){
        this.name = "PICK";
        this.durability = 100;
        this.hitValue = 5;
    }

    @Override
    public void accept(TargetVisitor targetVisitor) throws RemoveFromInventory {
        targetVisitor.allowUsage(this);
    }
}
