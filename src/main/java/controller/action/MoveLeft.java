package controller.action;

import exceptions.CrossedLeft;
import controller.GameController;
import model.entities.EntityModel;
import model.entities.map.NullEntity;

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
        if (!target.hasCollision() || target.getClass() == NullEntity.class) entity.getPosition().left();
    }
}
