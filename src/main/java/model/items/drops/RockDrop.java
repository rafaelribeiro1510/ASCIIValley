package model.items.drops;

import controller.GameController;
import model.Position;
import model.entities.EntityModel;
import model.entities.map.MapEntity;
import model.entities.map.NullEntity;
import model.entities.map.RockEntity;

public class RockDrop extends Drop {

    public RockDrop(){
        super("ROCK");
    }

    @Override
    public void use(GameController controller, Position position) {
        EntityModel target = controller.getMapModel().thisChunk().getEntityAt(position);
        if (target.getClass() == NullEntity.class) {
            this.decrementAmount();
            controller.getMapModel().thisChunk().getEntities().add(new RockEntity(position));
        }
    }
}
