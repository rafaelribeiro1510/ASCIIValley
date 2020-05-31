package com.g64.model.items.tools;

import com.g64.model.entities.visitors.ItemVisitor;

public class Pickaxe extends Tool {
    public Pickaxe(int durability){
        this.name = "PICK";
        this.durability = durability;
        this.hitValue = 5;
    }

    @Override
    public usageValue accept(ItemVisitor itemVisitor) {
        return itemVisitor.allowUsage(this);
    }
}
