package model.items.drops;

import controller.GameController;
import model.Position;
import model.entities.EntityModel;
import model.entities.map.TallGrassEntity;
import model.entities.map.NullEntity;
import model.terrain.GrassTerrain;
import model.terrain.MapTerrain;

public class TallGrassDrop extends Drop {

    public TallGrassDrop(){
        super("GRSS");
    }

    @Override
    public void use(GameController controller, Position position) {
        EntityModel targetEntity = controller.getMapModel().thisChunk().getEntityAt(position);
        MapTerrain targetTerrain = controller.getMapModel().thisChunk().getTerrainAt(position);
        if (targetEntity.getClass() == NullEntity.class && targetTerrain.getClass() == GrassTerrain.class) {
            this.decrementAmount();
            controller.getMapModel().thisChunk().getEntities().add(new TallGrassEntity(position));
        }
    }
}
