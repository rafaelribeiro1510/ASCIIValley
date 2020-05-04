package controller.action;

import Exceptions.CrossedWest;
import controller.GameController;
import model.MapEntityModel;
import model.MapModel;

public class MoveLeft implements ActionEvent {
    private final GameController controller;

    public MoveLeft(GameController controller) { this.controller = controller; }

    @Override
    public void execute() throws CrossedWest {
        MapEntityModel target = controller.getMapModel().thisChunk().getEntityAt(controller.getPlayer().getPosition().checkLeft(GameController.MAP_WIDTH));
        if (!target.hasCollision()) controller.getPlayer().getPosition().left();
    }
}
