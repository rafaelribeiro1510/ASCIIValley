package com.g64.model.items.drops;

import com.g64.model.Position;
import com.g64.model.entities.EntityModel;
import com.g64.model.entities.plant.CarrotSeedEntity;
import com.g64.model.entities.visitors.ItemVisitor;

public class CarrotSeedDrop extends SeedDrop {

    @Override
    public EntityModel getEntityFromDrop(Position position) {
        return new CarrotSeedEntity(position);
    }

    @Override
    public usageValue accept(ItemVisitor itemVisitor) {
        return itemVisitor.allowUsage(this);
    }
}
