package com.g64.model.items.drops;

import com.g64.model.Position;
import com.g64.model.entities.EntityModel;
import com.g64.model.entities.map.TreeEntity;
import com.g64.model.entities.visitors.ItemVisitor;

public class LogDrop extends Drop {

    public LogDrop(){
        super("LOG");
    }

    @Override
    public EntityModel getEntityFromDrop(Position position) {
        return new TreeEntity(position);
    }

    @Override
    public usageValue accept(ItemVisitor itemVisitor) {
        return itemVisitor.allowUsage(this);
    }
}
