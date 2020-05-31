package com.g64.model.items.drops;

import com.g64.model.entities.visitors.ItemVisitor;

public class GrownCarrotDrop extends ConsumableDrop {
    public GrownCarrotDrop() {
        super("CRRT", 5);
    }

    @Override
    public usageValue accept(ItemVisitor itemVisitor) {
        return itemVisitor.allowUsage(this);
    }

}
