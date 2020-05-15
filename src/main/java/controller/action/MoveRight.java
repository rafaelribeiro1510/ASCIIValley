package controller.action;

import exceptions.CrossedRight;
import controller.GameController;
import model.entities.EntityModel;
import model.entities.map.NullEntity;

public class MoveRight implements ActionEvent {
    private final GameController controller;

    public MoveRight(GameController controller) { this.controller = controller; }

    @Override
    public void execute() throws CrossedRight {
        EntityModel target = controller.getMapModel().thisChunk().getEntityAt(controller.getPlayer().getPosition().checkRight(GameController.MAP_WIDTH));
        if (!target.hasCollision() || target.getClass() == NullEntity.class) controller.getPlayer().getPosition().right();
    }
}
