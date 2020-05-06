package model.items.drops;

import model.items.Item;

public abstract class Drop extends Item {
    int amount;

    public Drop(){
        amount = 1;
    }

    public void incrementAmount(){ amount++; }

    public void decrementAmount(){ if (amount > 0) amount--; }

    public int getValue(){ return amount; }
}
