package com.g64.model.items.drops;

import com.g64.exceptions.Broke;
import com.g64.model.items.Item;

public abstract class Drop extends Item {
    int amount;

    public Drop(String name){
        amount = 1;
        this.name = name;
    }

    public void incrementAmount(){ amount++; }

    public void decrementValue() throws Broke {
        amount--;
        if (amount <= 0) throw new Broke();
    }

    public int getValue(){ return amount; }
}
