package com.g64.model.items.tools;

import com.g64.controller.GameController;
import com.g64.model.Position;
import com.g64.model.terrain.GrassTerrain;
import com.g64.model.terrain.MapTerrain;
import com.g64.model.terrain.SoilTerrain;

public class Hoe extends Tool {
    public Hoe(){
        this.name = "HOE";
        this.durability = 100;
    }

    @Override
    public boolean canBeUsed(GameController controller, Position position) {
        MapTerrain target = controller.getMapModel().thisChunk().getTerrainAt(position);
        return (target instanceof GrassTerrain);
    }

    @Override
    public void itemEffectsOnMap(GameController controller, Position position) {
        MapTerrain target = controller.getMapModel().thisChunk().getTerrainAt(position);
        controller.getMapModel().thisChunk().getTerrain().remove(target);
        controller.getMapModel().thisChunk().getTerrain().add(new SoilTerrain(position));
    }
}
