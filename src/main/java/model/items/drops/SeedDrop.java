package model.items.drops;

import controller.GameController;
import model.Position;
import model.entities.map.MapEntity;
import model.entities.map.NullEntity;
import model.entities.map.SeedEntity;
import model.terrain.MapTerrain;
import model.terrain.SoilTerrain;

public class SeedDrop extends Drop {

    public SeedDrop(){
        super("SEED");
    }

    @Override
    public void use(GameController controller, Position position) {
        MapEntity targetEntity = controller.getMapModel().thisChunk().getEntityAt(position);
        MapTerrain targetTerrain = controller.getMapModel().thisChunk().getTerrainAt(position);
        if (targetEntity.getClass() == NullEntity.class && targetTerrain.getClass() == SoilTerrain.class) {
            this.decrementAmount();
            controller.getMapModel().thisChunk().getEntities().add(new SeedEntity(position));
        }
    }
}
