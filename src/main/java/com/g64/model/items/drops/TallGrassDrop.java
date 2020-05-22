package com.g64.model.items.drops;

import com.g64.controller.GameController;
import com.g64.exceptions.RemoveFromInventory;
import com.g64.model.Position;
import com.g64.model.entities.plant.TallGrassEntity;
import com.g64.model.entities.target.Target;

public class TallGrassDrop extends Drop {

    public TallGrassDrop(){
        super("GRSS");
    }

    public void use(GameController controller, Position position) throws RemoveFromInventory {
        if (new Target(controller.getMapModel().thisChunk().getEntityAt(position), controller.getMapModel().thisChunk().getTerrainAt(position)).allowUsage(this)) {
            itemEffectsOnMap(controller, position);
            this.decrementValue();
        }
    }

    @Override
    public void itemEffectsOnMap(GameController controller, Position position) {
        controller.getMapModel().thisChunk().getEntities().add(new TallGrassEntity(position));
    }
}
