package com.g64.model.items;

import com.g64.model.entities.visitors.ItemVisitor;

public interface Item {
    String getName();

    int getValue();

    enum usageValue {
        UNUSED,
        NOT_BROKEN,
        BROKEN
    }
    usageValue decrementValue();

    usageValue accept(ItemVisitor itemVisitor);
}
