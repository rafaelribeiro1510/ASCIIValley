package model.items.drops;

import model.items.Item;

public abstract class Drop extends Item {
    int amount;

    public Drop(String name){
        amount = 1;
        this.name = name;
    }

    public void incrementAmount(){ amount++; }

    public void decrementAmount(){ if (amount > 0) amount--; }

    public int getValue(){ return amount; }
}
