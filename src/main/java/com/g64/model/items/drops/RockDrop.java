package com.g64.model.items.drops;

import com.g64.model.Position;
import com.g64.model.entities.EntityModel;
import com.g64.model.entities.map.RockEntity;
import com.g64.model.entities.visitors.TargetVisitor;

public class RockDrop extends Drop {

    public RockDrop(){
        super("ROCK");
    }

    @Override
    public EntityModel getEntityFromDrop(Position position) {
        return new RockEntity(position);
    }

    @Override
    public usageValue accept(TargetVisitor targetVisitor) {
        return targetVisitor.allowUsage(this);
    }
}
