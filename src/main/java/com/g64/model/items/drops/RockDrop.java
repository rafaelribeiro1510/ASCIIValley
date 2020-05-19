package com.g64.model.items.drops;

import com.g64.controller.GameController;
import com.g64.model.Position;
import com.g64.model.entities.EntityModel;
import com.g64.model.entities.map.NullEntity;
import com.g64.model.entities.map.RockEntity;

public class RockDrop extends Drop {

    public RockDrop(){
        super("ROCK");
    }

    @Override
    public boolean canBeUsed(GameController controller, Position position) {
        EntityModel target = controller.getMapModel().thisChunk().getEntityAt(position);
        return (target instanceof NullEntity);
    }

    @Override
    public void itemEffectsOnMap(GameController controller, Position position) {
        controller.getMapModel().thisChunk().getEntities().add(new RockEntity(position));
    }
}
