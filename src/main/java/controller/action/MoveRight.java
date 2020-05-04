package controller.action;

import Exceptions.CrossedEast;
import controller.GameController;
import model.MapEntityModel;
import model.MapModel;

public class MoveRight implements ActionEvent {
    private final GameController controller;

    public MoveRight(GameController controller) { this.controller = controller; }

    @Override
    public void execute() throws CrossedEast {
        MapEntityModel target = controller.getMapModel().thisChunk().getEntityAt(controller.getPlayer().getPosition().checkRight(GameController.MAP_WIDTH));
        if (!target.hasCollision()) controller.getPlayer().getPosition().right();
    }
}
