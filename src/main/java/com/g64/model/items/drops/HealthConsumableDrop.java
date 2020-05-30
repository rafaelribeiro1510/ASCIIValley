package com.g64.model.items.drops;

import com.g64.model.entities.visitors.TargetVisitor;

public class HealthConsumableDrop extends ConsumableDrop {
    public HealthConsumableDrop(){
        super("HLTH", 10);
    }

    @Override
    public usageValue accept(TargetVisitor targetVisitor) {
        return targetVisitor.allowUsage(this);
    }
}
