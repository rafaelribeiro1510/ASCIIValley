package com.g64.model.items.drops;

import com.g64.exceptions.RemoveFromInventory;
import com.g64.model.Position;
import com.g64.model.entities.EntityModel;
import com.g64.model.entities.plant.TallGrassEntity;
import com.g64.model.entities.visitors.TargetVisitor;

public class TallGrassDrop extends Drop {

    public TallGrassDrop(){
        super("GRSS");
    }

    @Override
    public EntityModel getEntityFromDrop(Position position) {
        return new TallGrassEntity(position);
    }

    @Override
    public void accept(TargetVisitor targetVisitor) throws RemoveFromInventory {
        targetVisitor.allowUsage(this);
    }
}
