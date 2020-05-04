package controller.action;

import exceptions.CrossedUp;
import controller.GameController;
import model.map.MapEntity;

public class MoveUp implements ActionEvent {
    private final GameController controller;

    public MoveUp(GameController controller) { this.controller = controller; }

    @Override
    public void execute() throws CrossedUp {
        MapEntity target = controller.getMapModel().thisChunk().getEntityAt(controller.getPlayer().getPosition().checkUp(GameController.MAP_HEIGHT));
        if (!target.hasCollision()) controller.getPlayer().getPosition().up();
    }
}
