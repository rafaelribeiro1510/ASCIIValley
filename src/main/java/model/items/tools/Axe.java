package model.items.tools;

import controller.GameController;
import model.Position;
import model.entities.map.MapEntity;
import model.entities.map.TreeEntity;

public class Axe extends Tool {
    public Axe() {
        this.name = "AXE";
        this.durability = 100;
    }

    @Override
    public void use(GameController controller, Position position){
        MapEntity target = controller.getMapModel().thisChunk().getEntityAt(position);
        if(target.getClass() == TreeEntity.class && this.durability > 0) {
            this.decrementDurability();
            controller.getInventoryModel().add(target.getRandomDrop());
            controller.getMapModel().thisChunk().getEntities().remove(target);
        }
    }
}
