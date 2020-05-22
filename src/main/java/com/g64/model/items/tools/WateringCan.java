package com.g64.model.items.tools;

import com.g64.exceptions.RemoveFromInventory;
import com.g64.model.entities.target.Target;

public class WateringCan extends Tool{
    public WateringCan() {
        this.name = "CAN";
        this.durability = 100;
        this.hitValue = 60;
    }

    @Override
    public void accept(Target target) throws RemoveFromInventory {
        target.allowUsage(this);
    }
}
