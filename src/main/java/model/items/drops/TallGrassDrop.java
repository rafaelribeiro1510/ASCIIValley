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
