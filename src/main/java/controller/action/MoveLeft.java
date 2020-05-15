package controller.action;

import exceptions.CrossedLeft;
import controller.GameController;
import model.entities.EntityModel;
import model.entities.map.NullEntity;

public class MoveLeft implements ActionEvent {
    private final GameController controller;

    public MoveLeft(GameController controller) { this.controller = controller; }

    @Override
    public void execute() throws CrossedLeft {
        EntityModel target = controller.getMapModel().thisChunk().getEntityAt(controller.getPlayer().getPosition().checkLeft(GameController.MAP_WIDTH));
        if (!target.hasCollision() || target.getClass() == NullEntity.class) controller.getPlayer().getPosition().left();
    }
}
