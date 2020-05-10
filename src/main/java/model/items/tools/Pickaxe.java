package model.items.tools;

import controller.GameController;
import model.Position;
import model.entities.map.MapEntity;
import model.entities.map.RockEntity;

public class Pickaxe extends Tool {
    public Pickaxe(){
        this.name = "PICK";
        this.durability = 100;
    }

    @Override
    public void use(GameController controller, Position position) {
        MapEntity target = controller.getMapModel().thisChunk().getEntityAt(position);
        if(target.getClass() == RockEntity.class) {
            this.decrementDurability();
            controller.getInventoryModel().add(target.getRandomDrop());
            controller.getMapModel().thisChunk().getEntities().remove(target);
        }
    }
}
