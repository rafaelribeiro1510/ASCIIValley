package model.items.drops;

import controller.GameController;
import model.Position;
import model.entities.MapEntity;
import model.map.InteractionType;

public class Rock extends Drop {

    public Rock(){
        super();
        this.name = "ROCK ";
    }

    @Override
    public void use(GameController controller, Position position) {
        MapEntity target = controller.getMapModel().thisChunk().getEntityAt(position);
        if (target.getType() == InteractionType.Null) {
            this.decrementAmount();
            target.replace("^");
        }
    }
}
