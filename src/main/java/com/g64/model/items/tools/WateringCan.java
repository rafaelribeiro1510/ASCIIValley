package com.g64.model.items.tools;

import com.g64.controller.GameController;
import com.g64.model.Position;
import com.g64.model.entities.EntityModel;
import com.g64.model.entities.plant.SeedEntity;

public class WateringCan extends Tool{
    public WateringCan() {
        this.name = "CAN";
        this.durability = 100;
        this.hitValue = 60;
    }

    @Override
    public boolean canBeUsed(GameController controller, Position position) {
        EntityModel target = controller.getMapModel().thisChunk().getEntityAt(position);
        return (target instanceof SeedEntity);
    }

    @Override
    public void itemEffectsOnMap(GameController controller, Position position) {
        EntityModel target = controller.getMapModel().thisChunk().getEntityAt(position);
        ((SeedEntity)target).water(hitValue);
    }
}
