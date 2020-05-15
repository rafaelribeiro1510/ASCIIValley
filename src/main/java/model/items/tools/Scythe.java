package model.items.tools;

import controller.GameController;
import exceptions.Died;
import model.Position;
import model.entities.EntityModel;
import model.entities.map.SeedEntity;
import model.entities.map.TallGrassEntity;

public class Scythe extends Tool{
    public Scythe(){
        this.name = "SCYT";
        this.durability = 100;
        this.hitValue = 5;
    }

    @Override
    public void use(GameController controller, Position position){
        EntityModel target = controller.getMapModel().thisChunk().getEntityAt(position);
        if(target.getClass() == SeedEntity.class || target.getClass() == TallGrassEntity.class) { //TODO Ha forma de criar grupo de subclasses "Plant" ????
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
