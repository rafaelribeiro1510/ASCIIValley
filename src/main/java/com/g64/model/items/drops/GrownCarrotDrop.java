package com.g64.model.items.drops;

import com.g64.model.entities.visitors.TargetVisitor;

public class GrownCarrotDrop extends ConsumableDrop {
    public GrownCarrotDrop() {
        super("CRRT", 5);
    }

    @Override
    public usageValue accept(TargetVisitor targetVisitor) {
        return targetVisitor.allowUsage(this);
    }

}
