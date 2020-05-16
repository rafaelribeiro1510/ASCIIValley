package model.items.drops;

import controller.GameController;
import model.Position;
import model.entities.EntityModel;
import model.entities.map.NullEntity;
import model.entities.map.SeedEntity;
import model.terrain.MapTerrain;
import model.terrain.SoilTerrain;

public class SeedDrop extends Drop {

    public SeedDrop(){
        super("SEED");
    }

    @Override
    public boolean canBeUsed(GameController controller, Position position) {
        EntityModel targetEntity = controller.getMapModel().thisChunk().getEntityAt(position);
        MapTerrain targetTerrain = controller.getMapModel().thisChunk().getTerrainAt(position);
        return (targetEntity instanceof NullEntity && targetTerrain instanceof SoilTerrain);
    }

    @Override
    public void itemEffectsOnMap(GameController controller, Position position) {
        controller.getMapModel().thisChunk().getEntities().add(new SeedEntity(position));
    }
}
