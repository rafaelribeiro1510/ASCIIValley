package com.g64.model.entities.plant;

import com.g64.model.Position;
import com.g64.model.items.drops.CarrotSeedDrop;
import com.g64.model.items.drops.Drop;
import com.googlecode.lanterna.TextColor;

public class CarrotSeedEntity extends SeedEntity {
    public CarrotSeedEntity(Position position) {
        super(position, ":", new TextColor.RGB(182, 69, 0), false, new Drop[] {new CarrotSeedDrop()}, 1, 180);
    }

    public CarrotSeedEntity(Position position, int maxGrowth) {
        super(position, ":", new TextColor.RGB(182, 69, 0), false, new Drop[] {new CarrotSeedDrop()}, 1, maxGrowth);
    }

    @Override
    public PlantEntity getGrownEntity() {
        return new GrownCarrotEntity(this.position);
    }
}
