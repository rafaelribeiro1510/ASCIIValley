package model.items.tools;

import controller.GameController;
import model.Position;
import model.terrain.GrassTerrain;
import model.terrain.MapTerrain;
import model.terrain.SoilTerrain;

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
