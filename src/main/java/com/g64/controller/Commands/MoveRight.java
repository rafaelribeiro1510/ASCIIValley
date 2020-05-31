package com.g64.controller.Commands;

import com.g64.controller.GameController;
import com.g64.model.entities.EntityModel;

public class MoveRight implements Command {
    private final GameController controller;
    private final EntityModel entity;

    public MoveRight(GameController controller, EntityModel entity) {
        this.controller = controller;
        this.entity = entity;
    }

    @Override
    public void execute() {
        EntityModel target = controller.getMapModel().thisChunk().getEntityAt(entity.getPosition().lookRight());

        if (!target.hasCollision()) entity.getPosition().moveRight();
        entity.handleBoundaryCrossing(controller.getMapModel());
    }
}
