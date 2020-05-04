package controller.action;

import Exceptions.CrossedNorth;
import controller.GameController;
import model.MapEntityModel;
import model.MapModel;

public class MoveUp implements ActionEvent {
    private final GameController controller;

    public MoveUp(GameController controller) { this.controller = controller; }

    @Override
    public void execute() throws CrossedNorth {
        MapEntityModel target = controller.getMapModel().thisChunk().getEntityAt(controller.getPlayer().getPosition().checkUp(GameController.MAP_HEIGHT));
        if (!target.hasCollision()) controller.getPlayer().getPosition().up();
    }
}
