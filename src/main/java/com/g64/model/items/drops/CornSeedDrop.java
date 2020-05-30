package com.g64.model.items.drops;

import com.g64.model.Position;
import com.g64.model.entities.EntityModel;
import com.g64.model.entities.plant.CornSeedEntity;
import com.g64.model.entities.visitors.TargetVisitor;

public class CornSeedDrop extends SeedDrop {

    @Override
    public EntityModel getEntityFromDrop(Position position) {
        return new CornSeedEntity(position);
    }

    @Override
    public usageValue accept(TargetVisitor targetVisitor) {
        return targetVisitor.allowUsage(this);
    }
}
