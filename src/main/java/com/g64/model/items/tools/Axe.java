package com.g64.model.items.tools;

import com.g64.controller.GameController;
import com.g64.exceptions.Died;
import com.g64.model.Position;
import com.g64.model.entities.Enemy;
import com.g64.model.entities.EntityModel;
import com.g64.model.entities.map.TreeEntity;

public class Axe extends Tool {
    public Axe() {
        this.name = "AXE";
        this.durability = 100;
        this.hitValue = 5;
    }

    @Override
    public boolean canBeUsed(GameController controller, Position position) {
        EntityModel target = controller.getMapModel().thisChunk().getEntityAt(position);
        return (target instanceof TreeEntity || target instanceof Enemy);
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
