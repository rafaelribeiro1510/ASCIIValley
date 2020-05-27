package com.g64.controller.action;

import com.g64.controller.GameController;
import com.g64.exceptions.Died;
import com.g64.model.entities.enemy.Enemy;
import com.g64.model.entities.EntityModel;

public class MoveLeft implements ActionEvent {
    private final GameController controller;
    private final EntityModel entity;

    public MoveLeft(GameController controller, EntityModel entity) {
        this.controller = controller;
        this.entity = entity;
    }

    @Override
    public void execute() throws Died {
        EntityModel target = controller.getMapModel().thisChunk().getEntityAt(entity.getPosition().lookLeft());

        if (this.entity instanceof Enemy && target.getPosition().equals(controller.getPlayer().getPosition())) {
            controller.getPlayer().reduceHealth(((Enemy) this.entity).getAttackValue());
            return;
        }

        if (!target.hasCollision()) entity.getPosition().moveLeft();
    }

    @Override
    public EntityModel getEntity() {
        return entity;
    }
}
