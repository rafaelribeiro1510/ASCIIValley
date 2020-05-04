package controller.action;

import Exceptions.CrossedSouth;
import controller.GameController;
import model.MapEntityModel;
import model.MapModel;

public class MoveDown implements ActionEvent {
    private final GameController controller;

    public MoveDown(GameController controller) { this.controller = controller; }

    @Override
    public void execute() throws CrossedSouth {
        MapEntityModel target = controller.getMapModel().thisChunk().getEntityAt(controller.getPlayer().getPosition().checkDown(GameController.MAP_HEIGHT));
        if (!target.hasCollision()) controller.getPlayer().getPosition().down();
    }
}
