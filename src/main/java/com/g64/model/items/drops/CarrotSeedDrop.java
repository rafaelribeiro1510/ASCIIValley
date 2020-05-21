package com.g64.model.items.drops;

import com.g64.controller.GameController;
import com.g64.model.Position;
import com.g64.model.entities.plant.CarrotSeedEntity;

public class CarrotSeedDrop extends SeedDrop {
    @Override
    public void itemEffectsOnMap(GameController controller, Position position) {
        controller.getMapModel().thisChunk().getEntities().add(new CarrotSeedEntity(position));

    }
}
