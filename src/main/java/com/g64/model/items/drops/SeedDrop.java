package com.g64.model.items.drops;

import com.g64.controller.GameController;
import com.g64.model.Position;
import com.g64.model.entities.EntityModel;
import com.g64.model.entities.map.NullEntity;
import com.g64.model.entities.map.SeedEntity;
import com.g64.model.terrain.MapTerrain;
import com.g64.model.terrain.SoilTerrain;

public class SeedDrop extends Drop {

    public SeedDrop(){
        super("SEED");
    }

    @Override
    public boolean canBeUsed(GameController controller, Position position) {
        EntityModel targetEntity = controller.getMapModel().thisChunk().getEntityAt(position);
        MapTerrain targetTerrain = controller.getMapModel().thisChunk().getTerrainAt(position);
        return (targetEntity instanceof NullEntity && targetTerrain instanceof SoilTerrain);
    }

    @Override
    public void itemEffectsOnMap(GameController controller, Position position) {
        controller.getMapModel().thisChunk().getEntities().add(new SeedEntity(position));
    }
}
