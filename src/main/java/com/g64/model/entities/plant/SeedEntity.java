package com.g64.model.entities.plant;

import com.g64.controller.GameController;
import com.g64.model.entities.UpdatableEntity;
import com.googlecode.lanterna.TextColor;
import com.g64.model.Position;
import com.g64.model.items.drops.Drop;

public abstract class SeedEntity extends PlantEntity implements UpdatableEntity {
    int growth;

    public abstract void grow(GameController controller);

    public SeedEntity(Position position, String string, TextColor color, boolean collision, Drop[] drops, int maxHealth, int maxGrowth) {
        super(position, string, color, collision, drops, maxHealth);
        growth = maxGrowth;
    }

    @Override
    public void update(GameController controller) {
        growth--;
        if (growth <= 0) {
            controller.getMapModel().thisChunk().getEntities().remove(this);
            this.grow(controller);
        }
    }
}
