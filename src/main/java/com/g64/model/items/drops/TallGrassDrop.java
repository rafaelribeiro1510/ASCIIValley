package com.g64.model.items.drops;

import com.g64.controller.GameController;
import com.g64.model.Position;
import com.g64.model.entities.EntityModel;
import com.g64.model.entities.map.TallGrassEntity;
import com.g64.model.entities.map.NullEntity;
import com.g64.model.terrain.GrassTerrain;
import com.g64.model.terrain.MapTerrain;

public class TallGrassDrop extends Drop {

    public TallGrassDrop(){
        super("GRSS");
    }

    @Override
    public boolean canBeUsed(GameController controller, Position position) {
        EntityModel targetEntity = controller.getMapModel().thisChunk().getEntityAt(position);
        MapTerrain targetTerrain = controller.getMapModel().thisChunk().getTerrainAt(position);
        return (targetEntity instanceof NullEntity && targetTerrain instanceof GrassTerrain);
    }

    @Override
    public void itemEffectsOnMap(GameController controller, Position position) {
        controller.getMapModel().thisChunk().getEntities().add(new TallGrassEntity(position));
    }
}
