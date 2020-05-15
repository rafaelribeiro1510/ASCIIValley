package controller.action;

import exceptions.CrossedUp;
import controller.GameController;
import model.entities.EntityModel;
import model.entities.map.NullEntity;

public class MoveUp implements ActionEvent {
    private final GameController controller;

    public MoveUp(GameController controller) { this.controller = controller; }

    @Override
    public void execute() throws CrossedUp {
        EntityModel target = controller.getMapModel().thisChunk().getEntityAt(controller.getPlayer().getPosition().checkUp(GameController.MAP_HEIGHT));
        if (!target.hasCollision() || target.getClass() == NullEntity.class) controller.getPlayer().getPosition().up();
    }
}
