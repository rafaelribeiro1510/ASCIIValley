package controller.action;

import exceptions.CrossedLeft;
import controller.GameController;
import model.entities.MapEntity;

public class MoveLeft implements ActionEvent {
    private final GameController controller;

    public MoveLeft(GameController controller) { this.controller = controller; }

    @Override
    public void execute() throws CrossedLeft {
        MapEntity target = controller.getMapModel().thisChunk().getEntityAt(controller.getPlayer().getPosition().checkLeft(GameController.MAP_WIDTH));
        if (!target.hasCollision()) controller.getPlayer().getPosition().left();
    }
}
