package com.g64.controller.action;

import com.g64.controller.GameController;
import com.g64.model.entities.EntityModel;

public class MoveUp implements ActionEvent {
    private final GameController controller;
    private final EntityModel entity;

    public MoveUp(GameController controller, EntityModel entity) {
        this.controller = controller;
        this.entity = entity;
    }

    @Override
    public void execute() {
        EntityModel target = controller.getMapModel().thisChunk().getEntityAt(entity.getPosition().lookUp());

        if (!target.hasCollision()) entity.getPosition().moveUp();
        controller.getMapModel().handleMapCrossing(entity);
    }
}
