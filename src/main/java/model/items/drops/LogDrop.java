package model.items.drops;

import controller.GameController;
import model.Position;
import model.entities.map.MapEntity;
import model.entities.map.NullEntity;
import model.entities.map.TreeEntity;
import model.terrain.GrassTerrain;
import model.terrain.MapTerrain;

public class LogDrop extends Drop {

    public LogDrop(){
        super("LOG");
    }

    @Override
    public void use(GameController controller, Position position) {
        MapEntity targetEntity = controller.getMapModel().thisChunk().getEntityAt(position);
        MapTerrain targetTerrain = controller.getMapModel().thisChunk().getTerrainAt(position);
        if (targetEntity.getClass() == NullEntity.class && targetTerrain.getClass() == GrassTerrain.class) {
            this.decrementAmount();
            controller.getMapModel().thisChunk().getEntities().add(new TreeEntity(position));
        }
    }
}
