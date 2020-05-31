package com.g64.model.items.tools;

import com.g64.model.entities.visitors.ItemVisitor;

public class WateringCan extends Tool{
    public WateringCan(int durability) {
        this.name = "CAN";
        this.durability = durability;
        this.hitValue = 60;
    }

    @Override
    public usageValue accept(ItemVisitor itemVisitor) {
        return itemVisitor.allowUsage(this);
    }
}
