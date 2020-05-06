package model.items.tools;

import controller.GameController;
import model.Position;
import model.map.InteractionType;
import model.map.MapTerrain;

public class Hoe extends Tool {
    public Hoe(){
        this.name = "HOE  ";
        this.durability = 100;
    }

    @Override
    public void use(GameController controller, Position position) {
        MapTerrain target = controller.getMapModel().thisChunk().getTerrainAt(position);
        if(target.getType() == InteractionType.Grass) {
            this.decrementDurability();
            target.setType(InteractionType.Soil);
        }
    }
}
