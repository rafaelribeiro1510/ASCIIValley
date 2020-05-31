package com.g64.model.items.tools;

import com.g64.model.entities.visitors.ItemVisitor;

public class Axe extends Tool {
    public Axe(int durability) {
        this.name = "AXE";
        this.durability = durability;
        this.hitValue = 5;
    }

    @Override
    public usageValue accept(ItemVisitor itemVisitor) {
        return itemVisitor.allowUsage(this);
    }

}