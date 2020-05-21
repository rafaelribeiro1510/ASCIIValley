package com.g64.model.entities.plant;

import com.g64.controller.GameController;
import com.g64.model.Position;
import com.g64.model.items.drops.CarrotSeedDrop;
import com.g64.model.items.drops.Drop;
import com.googlecode.lanterna.TextColor;

public class CarrotSeedEntity extends SeedEntity {
    public CarrotSeedEntity(Position position) {
        super(position, ":", new TextColor.RGB(182, 69, 0), false, new Drop[] {new CarrotSeedDrop()}, 1, 180);
    }

    @Override
    public void grow(GameController controller) {
        controller.getMapModel().thisChunk().getEntities().add(new GrownCarrotEntity(this.position));
    }
}
