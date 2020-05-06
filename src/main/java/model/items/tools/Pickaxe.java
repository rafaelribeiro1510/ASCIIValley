package model.items.tools;

import controller.GameController;
import model.Position;
import model.map.InteractionType;
import model.entities.MapEntity;

public class Pickaxe extends Tool {
    public Pickaxe(){
        this.name = "PICK ";
        this.durability = 100;
    }

    @Override
    public void use(GameController controller, Position position) {
        MapEntity target = controller.getMapModel().thisChunk().getEntityAt(position);
        if(target.getType() == InteractionType.Rock) {
            this.decrementDurability();
            controller.getInventoryModel().add(target.getRandomDrop());
            target.remove();
        }
    }
}
