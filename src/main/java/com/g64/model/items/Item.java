package com.g64.model.items;

import com.g64.exceptions.RemoveFromInventory;
import com.g64.model.entities.target.Target;

public interface Item {
    String getName();

    int getValue();

    void decrementValue() throws RemoveFromInventory;

    void accept(Target target) throws RemoveFromInventory;
}
