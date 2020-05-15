package model.items.tools;

import controller.GameController;
import exceptions.Broke;
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
        if(target.getClass() == GrassTerrain.class) { //TODO getClass vs instaceof
            controller.getMapView().blink(position);
            try {
                this.decrementDurability();
            }
            catch (Broke broke) {
                controller.getInventoryModel().getItems().remove(this);
            }
            controller.getMapModel().thisChunk().getTerrain().remove(target);
            controller.getMapModel().thisChunk().getTerrain().add(new SoilTerrain(position));
        }
    }
}
