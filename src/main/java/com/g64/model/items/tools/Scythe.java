package com.g64.model.items.tools;

import com.g64.model.entities.visitors.ItemVisitor;

public class Scythe extends Tool{
    public Scythe(int durability){
        this.name = "SCYT";
        this.durability = durability;
        this.hitValue = 5;
    }

    @Override
    public usageValue accept(ItemVisitor itemVisitor) {
        return itemVisitor.allowUsage(this);
    }
}
