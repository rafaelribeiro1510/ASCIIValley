package controller.action;

import exceptions.CrossedRight;
import controller.GameController;
import model.entities.EntityModel;
import model.entities.map.NullEntity;

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
        if (!target.hasCollision() || target.getClass() == NullEntity.class) entity.getPosition().right();
    }
}
