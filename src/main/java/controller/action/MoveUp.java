package controller.action;

import exceptions.CrossedUp;
import controller.GameController;
import model.entities.EntityModel;
import model.entities.map.NullEntity;

public class MoveUp implements ActionEvent {
    private final GameController controller;
    private final EntityModel entity;

    public MoveUp(GameController controller, EntityModel entity) {
        this.controller = controller;
        this.entity = entity;
    }

    @Override
    public void execute() throws CrossedUp {
        EntityModel target = controller.getMapModel().thisChunk().getEntityAt(entity.getPosition().checkUp(GameController.MAP_HEIGHT));
        if (!target.hasCollision() || target.getClass() == NullEntity.class) entity.getPosition().up();
    }
}
