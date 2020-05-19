package com.g64.controller.action;

import com.g64.exceptions.CrossedLeft;
import com.g64.controller.GameController;
import com.g64.exceptions.Died;
import com.g64.model.entities.Enemy;
import com.g64.model.entities.EntityModel;
import com.g64.model.entities.map.NullEntity;

public class MoveLeft implements ActionEvent {
    private final GameController controller;
    private final EntityModel entity;

    public MoveLeft(GameController controller, EntityModel entity) {
        this.controller = controller;
        this.entity = entity;
    }

    @Override
    public void execute() throws CrossedLeft {
        EntityModel target = controller.getMapModel().thisChunk().getEntityAt(entity.getPosition().checkLeft(GameController.MAP_WIDTH));

        if (this.entity instanceof Enemy && target.getPosition().equals(controller.getPlayer().getPosition())) {
            try {
                controller.getPlayer().reduceHealth(((Enemy) this.entity).getAttackValue());
                return;
            } catch (Died died) {
                //GAME OVER
                died.printStackTrace();
            }
        }

        if (!target.hasCollision() || target.getClass() == NullEntity.class) entity.getPosition().left();
    }
}
