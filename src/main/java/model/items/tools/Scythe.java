package model.items.tools;

import controller.GameController;
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
    public boolean canBeUsed(GameController controller, Position position) {
        EntityModel target = controller.getMapModel().thisChunk().getEntityAt(position);
        return (target instanceof PlantEntity);
    }

    @Override
    public void itemEffectsOnMap(GameController controller, Position position) {
        EntityModel target = controller.getMapModel().thisChunk().getEntityAt(position);
        try{
            target.reduceHealth(this.hitValue);
        } catch (Died died) {
            controller.getInventoryModel().add(target.getRandomDrop());
            controller.getMapModel().thisChunk().getEntities().remove(target);
        }
    }
}
