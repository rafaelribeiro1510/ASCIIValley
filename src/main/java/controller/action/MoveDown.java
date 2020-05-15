package controller.action;

import exceptions.CrossedDown;
import controller.GameController;
import model.entities.EntityModel;
import model.entities.map.NullEntity;

public class MoveDown implements ActionEvent {
    private final GameController controller;
    private final EntityModel entity;

    public MoveDown(GameController controller, EntityModel entity) {
        this.controller = controller;
        this.entity = entity;
    }

    @Override
    public void execute() throws CrossedDown {
        EntityModel target = controller.getMapModel().thisChunk().getEntityAt(entity.getPosition().checkDown(GameController.MAP_HEIGHT));
        if (!target.hasCollision() || target.getClass() == NullEntity.class) entity.getPosition().down();
    }
}
