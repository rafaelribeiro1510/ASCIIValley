package model.items.drops;

import controller.GameController;
import model.Position;
import model.entities.MapEntity;
import model.map.InteractionType;
import model.map.MapTerrain;

public class Grass extends Drop {

    public Grass(){
        super();
        this.name = "GRSS ";
    }

    @Override
    public void use(GameController controller, Position position) {
        MapEntity targetEntity = controller.getMapModel().thisChunk().getEntityAt(position);
        MapTerrain targetTerrain = controller.getMapModel().thisChunk().getTerrainAt(position);
        if (targetEntity.getType() == InteractionType.Null && targetTerrain.getType() == InteractionType.Grass) {
            this.decrementAmount();
            targetEntity.replace("y");
        }
    }
}
