package com.g64.model.entities.plant;

import com.g64.model.Position;
import com.g64.model.items.drops.CornSeedDrop;
import com.g64.model.items.drops.Drop;
import com.googlecode.lanterna.TextColor;

public class CornSeedEntity extends SeedEntity {
    public CornSeedEntity(Position position){
        super(position, ":", new TextColor.RGB(182, 143, 0), false, new Drop[] {new CornSeedDrop()}, 1, 240);
    }

    public CornSeedEntity(Position position, int maxGrowth){
        super(position, ":", new TextColor.RGB(182, 143, 0), false, new Drop[] {new CornSeedDrop()}, 1, maxGrowth);
    }


    @Override
    public PlantEntity getGrownEntity() {
        return new GrownCornEntity(this.position);
    }
}
