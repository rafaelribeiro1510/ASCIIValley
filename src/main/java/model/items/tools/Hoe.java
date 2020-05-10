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
    public void use(GameController controller, Position position) {
        MapTerrain target = controller.getMapModel().thisChunk().getTerrainAt(position);
        if(target.getClass() == GrassTerrain.class) {
            controller.getMapView().blink(position);
            this.decrementDurability();
            controller.getMapModel().thisChunk().getTerrain().remove(target);
            controller.getMapModel().thisChunk().getTerrain().add(new SoilTerrain(position));
        }
    }
}
