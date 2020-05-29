package com.g64.model.items;

import com.g64.exceptions.RemoveFromInventory;
import com.g64.model.entities.visitors.TargetVisitor;

public interface Item {
    String getName();

    int getValue();

    void setValue(int value);

    void decrementValue() throws RemoveFromInventory;

    void accept(TargetVisitor targetVisitor) throws RemoveFromInventory;
}
