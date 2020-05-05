package model.items;

import controller.GameController;
import model.Position;
import model.map.InteractionType;
import model.map.MapEntity;

public class Axe extends Item {
    public Axe() {
        this.name = "AXE ";
        this.durability = 200;
    }

    @Override
    public void use(GameController controller, Position position){
        MapEntity target = controller.getMapModel().thisChunk().getEntityAt(position);
        if(target.getType() == InteractionType.Wood) {
            this.durability--;
            target.remove();
        }
    }
}
