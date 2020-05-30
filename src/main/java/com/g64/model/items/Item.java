package com.g64.model.items;

import com.g64.model.entities.visitors.TargetVisitor;

public interface Item {
    String getName();

    int getValue();

    enum itemValue{
        UNUSED,
        NOT_BROKEN,
        BROKEN
    }
    itemValue decrementValue();

    itemValue accept(TargetVisitor targetVisitor);
}
