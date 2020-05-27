package com.g64.controller.action;

import com.g64.controller.GameController;
import com.g64.exceptions.Died;
import com.g64.model.entities.enemy.Enemy;
import com.g64.model.entities.EntityModel;

public class MoveDown implements ActionEvent {
    private final GameController controller;
    private final EntityModel entity;

    public MoveDown(GameController controller, EntityModel entity) {
        this.controller = controller;
        this.entity = entity;
    }

    @Override
    public void execute() throws Died{
        //TODO this smell vv
        EntityModel target = controller.getMapModel().thisChunk().getEntityAt(entity.getPosition().lookDown());

        if (this.entity instanceof Enemy && target.getPosition().equals(controller.getPlayer().getPosition())) {
            controller.getPlayer().reduceHealth(((Enemy) this.entity).getAttackValue());
            return;
        }

        if (!target.hasCollision()) entity.getPosition().moveDown();
    }
}
