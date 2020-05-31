package com.g64.model.items.drops;

import com.g64.model.entities.visitors.ItemVisitor;

public class HealthPackDrop extends ConsumableDrop {
    public HealthPackDrop(){
        super("HLTH", 10);
    }

    @Override
    public usageValue accept(ItemVisitor itemVisitor) {
        return itemVisitor.allowUsage(this);
    }
}
