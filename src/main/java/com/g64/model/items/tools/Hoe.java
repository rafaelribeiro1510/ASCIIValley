package com.g64.model.items.tools;

import com.g64.exceptions.RemoveFromInventory;
import com.g64.model.entities.target.Target;

public class Hoe extends Tool {
    public Hoe(){
        this.name = "HOE";
        this.durability = 100;
    }

    @Override
    public void accept(Target target) throws RemoveFromInventory {
        target.allowUsage(this);
    }
}
