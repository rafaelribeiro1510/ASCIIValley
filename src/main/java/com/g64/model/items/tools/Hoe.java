package com.g64.model.items.tools;

import com.g64.model.entities.visitors.ItemVisitor;

public class Hoe extends Tool {
    public Hoe(int durability){
        this.name = "HOE";
        this.durability = durability;
    }

    @Override
    public usageValue accept(ItemVisitor itemVisitor) {
        return itemVisitor.allowUsage(this);
    }
}
