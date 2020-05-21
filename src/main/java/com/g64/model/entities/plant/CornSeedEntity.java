package com.g64.model.entities.plant;

import com.g64.controller.GameController;
import com.g64.model.Position;
import com.g64.model.items.drops.CornSeedDrop;
import com.g64.model.items.drops.Drop;
import com.googlecode.lanterna.TextColor;

public class CornSeedEntity extends SeedEntity {
    public CornSeedEntity(Position position){
        super(position, ":", new TextColor.RGB(182, 143, 0), false, new Drop[] {new CornSeedDrop()}, 1, 240);
    }

    @Override
    public void grow(GameController controller) {
        controller.getMapModel().thisChunk().getEntities().add(new GrownCornEntity(this.position));
    }
}
