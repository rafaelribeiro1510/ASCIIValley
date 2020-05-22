package com.g64.model.items.drops;

import com.g64.model.Position;
import com.g64.model.entities.EntityModel;
import com.g64.model.entities.map.NullEntity;

public abstract class ConsumableDrop extends Drop {
    int healthUpValue;

    public ConsumableDrop(String name, int healthUpValue) {
        super(name);
        this.healthUpValue = healthUpValue;
    }

    public int getHealthUpValue(){ return healthUpValue; }

    public EntityModel getEntityFromDrop(Position position){
        return new NullEntity(position);
    }

}
