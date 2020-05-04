package model.items;

import controller.GameController;
import model.Position;
import model.map.InteractionType;
import model.map.MapEntity;

public class Pickaxe extends Item {
    public Pickaxe(){ name = "PICK"; }

    @Override
    public void use(GameController controller, Position position) {
        MapEntity target = controller.getMapModel().thisChunk().getEntityAt(position);
        if(target.getType() == InteractionType.Rock) target.remove();
    }
}
