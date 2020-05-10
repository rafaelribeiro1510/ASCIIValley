package model.items.tools;

import controller.GameController;
import exceptions.Died;
import model.Position;
import model.entities.map.MapEntity;
import model.entities.map.RockEntity;

public class Pickaxe extends Tool {
    public Pickaxe(){
        this.name = "PICK";
        this.durability = 100;
        this.hitValue = 5;
    }

    @Override
    public void use(GameController controller, Position position) {
        MapEntity target = controller.getMapModel().thisChunk().getEntityAt(position);
        if(target.getClass() == RockEntity.class) {
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
