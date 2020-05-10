package model.items.tools;

import controller.GameController;
import exceptions.Died;
import model.Position;
import model.entities.map.MapEntity;
import model.entities.map.TreeEntity;

public class Axe extends Tool {
    public Axe() {
        this.name = "AXE";
        this.durability = 100;
        this.hitValue = 5;
    }

    @Override
    public void use(GameController controller, Position position){
        MapEntity target = controller.getMapModel().thisChunk().getEntityAt(position);
        if(target.getClass() == TreeEntity.class && this.durability > 0) {
            controller.getMapView().blink(position);
            this.decrementDurability();
            try {
                target.reduceHealth(this.hitValue);
            } catch (Died died) {
                controller.getInventoryModel().add(target.getRandomDrop());
                controller.getMapModel().thisChunk().getEntities().remove(target);
            }
        }
    }
}
