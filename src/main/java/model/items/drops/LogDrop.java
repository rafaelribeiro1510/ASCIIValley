package model.items.drops;

import controller.GameController;
import model.Position;
import model.entities.EntityModel;
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
    public boolean canBeUsed(GameController controller, Position position) {
        EntityModel targetEntity = controller.getMapModel().thisChunk().getEntityAt(position);
        MapTerrain targetTerrain = controller.getMapModel().thisChunk().getTerrainAt(position);
        return (targetEntity instanceof NullEntity && targetTerrain instanceof GrassTerrain);
    }

    @Override
    public void itemEffectsOnMap(GameController controller, Position position) {
        controller.getMapModel().thisChunk().getEntities().add(new TreeEntity(position));
    }
}
