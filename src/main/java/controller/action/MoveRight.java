package controller.action;

import exceptions.CrossedRight;
import controller.GameController;
import model.entities.MapEntity;

public class MoveRight implements ActionEvent {
    private final GameController controller;

    public MoveRight(GameController controller) { this.controller = controller; }

    @Override
    public void execute() throws CrossedRight {
        MapEntity target = controller.getMapModel().thisChunk().getEntityAt(controller.getPlayer().getPosition().checkRight(GameController.MAP_WIDTH));
        if (!target.hasCollision()) controller.getPlayer().getPosition().right();
    }
}
