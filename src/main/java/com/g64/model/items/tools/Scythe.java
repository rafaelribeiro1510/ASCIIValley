package com.g64.model.items.tools;

import com.g64.controller.GameController;
import com.g64.exceptions.Died;
import com.g64.exceptions.RemoveFromInventory;
import com.g64.model.Position;
import com.g64.model.entities.EntityModel;
import com.g64.model.entities.target.Target;

public class Scythe extends Tool{
    public Scythe(){
        this.name = "SCYT";
        this.durability = 100;
        this.hitValue = 5;
    }

    public void use(GameController controller, Position position) throws RemoveFromInventory {
        if (new Target(controller.getMapModel().thisChunk().getEntityAt(position), controller.getMapModel().thisChunk().getTerrainAt(position)).allowUsage(this)) {
            itemEffectsOnMap(controller, position);
            this.decrementValue();
        }
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
