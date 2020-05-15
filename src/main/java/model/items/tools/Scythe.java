package model.items.tools;

import controller.GameController;
import exceptions.Broke;
import exceptions.Died;
import model.Position;
import model.entities.EntityModel;
import model.entities.map.PlantEntity;

public class Scythe extends Tool{
    public Scythe(){
        this.name = "SCYT";
        this.durability = 100;
        this.hitValue = 5;
    }

    @Override
    public void use(GameController controller, Position position){
        EntityModel target = controller.getMapModel().thisChunk().getEntityAt(position);
        if(target instanceof PlantEntity) {
            controller.getMapView().blink(position);

            try {
                this.decrementDurability();
                target.reduceHealth(this.hitValue);
            }
            catch (Broke broke) {
                controller.getInventoryModel().getItems().remove(this);
            }
            catch (Died died) {
                controller.getInventoryModel().add(target.getRandomDrop());
                controller.getMapModel().thisChunk().getEntities().remove(target);
            }
        }
    }
}
