package com.g64.controller.action;

import com.g64.exceptions.CrossedRight;
import com.g64.controller.GameController;
import com.g64.exceptions.Died;
import com.g64.model.entities.enemy.Enemy;
import com.g64.model.entities.EntityModel;
import com.g64.model.entities.map.NullEntity;

public class MoveRight implements ActionEvent {
    private final GameController controller;
    private final EntityModel entity;

    public MoveRight(GameController controller, EntityModel entity) {
        this.controller = controller;
        this.entity = entity;
    }

    @Override
    public void execute() throws CrossedRight {
        EntityModel target = controller.getMapModel().thisChunk().getEntityAt(entity.getPosition().checkRight(GameController.MAP_WIDTH));

        if (this.entity instanceof Enemy && target.getPosition().equals(controller.getPlayer().getPosition())) {
            try {
                controller.getPlayer().reduceHealth(((Enemy) this.entity).getAttackValue());
                return;
            } catch (Died died) {
                //GAME OVER
                died.printStackTrace();
            }
        }

        if (!target.hasCollision() || target instanceof NullEntity) entity.getPosition().right();
    }
}
