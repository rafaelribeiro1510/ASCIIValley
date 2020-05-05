package model.items;

import controller.GameController;
import model.Position;
import model.map.InteractionType;
import model.map.MapTerrain;

public class Hoe extends Item {
    public Hoe(){
        name = "HOE ";
    }

    @Override
    public void use(GameController controller, Position position) {
        MapTerrain target = controller.getMapModel().thisChunk().getTerrainAt(position);
        if(target.getType() == InteractionType.Grass) target.setType(InteractionType.Soil);
    }
}
