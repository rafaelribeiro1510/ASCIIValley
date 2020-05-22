package com.g64.model.items.tools;

import com.g64.exceptions.RemoveFromInventory;
import com.g64.model.entities.target.Target;

public class Scythe extends Tool{
    public Scythe(){
        this.name = "SCYT";
        this.durability = 100;
        this.hitValue = 5;
    }

    @Override
    public void accept(Target target) throws RemoveFromInventory {
        target.allowUsage(this);
    }
}
