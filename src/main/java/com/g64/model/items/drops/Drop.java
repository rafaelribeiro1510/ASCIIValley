package com.g64.model.items.drops;

import com.g64.model.Position;
import com.g64.model.entities.EntityModel;
import com.g64.model.items.Item;

public abstract class Drop implements Item {
    protected String name;
    protected int amount;

    public Drop(String name){
        amount = 1;
        this.name = name;
    }

    public String getName(){ return this.name; }

    public void incrementAmount(){ amount++; }

    public itemValue decrementValue() {
        amount--;
        if (amount <= 0) return itemValue.BROKEN;
        return itemValue.NOT_BROKEN;
    }

    public int getValue(){ return amount; }

    public abstract EntityModel getEntityFromDrop(Position position);

}
