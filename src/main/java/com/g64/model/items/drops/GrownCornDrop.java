package com.g64.model.items.drops;

import com.g64.model.entities.visitors.TargetVisitor;

public class GrownCornDrop extends ConsumableDrop {
    public GrownCornDrop() {
        super("CORN", 5);
    }

    @Override
    public itemValue accept(TargetVisitor targetVisitor) {
        return targetVisitor.allowUsage(this);
    }
}
