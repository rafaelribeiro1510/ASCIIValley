package com.g64.model.items.drops;

import com.g64.exceptions.RemoveFromInventory;
import com.g64.model.Position;
import com.g64.model.entities.EntityModel;
import com.g64.model.entities.plant.CornSeedEntity;
import com.g64.model.entities.target.Target;

public class CornSeedDrop extends SeedDrop {

    @Override
    public EntityModel getEntityFromDrop(Position position) {
        return new CornSeedEntity(position);
    }

    @Override
    public void accept(Target target) throws RemoveFromInventory {
        target.allowUsage(this);
    }
}
