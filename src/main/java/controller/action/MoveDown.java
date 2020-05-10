package controller.action;

import exceptions.CrossedDown;
import controller.GameController;
import model.entities.map.MapEntity;
import model.entities.map.NullEntity;

public class MoveDown implements ActionEvent {
    private final GameController controller;

    public MoveDown(GameController controller) { this.controller = controller; }

    @Override
    public void execute() throws CrossedDown {
        MapEntity target = controller.getMapModel().thisChunk().getEntityAt(controller.getPlayer().getPosition().checkDown(GameController.MAP_HEIGHT));
        if (!target.hasCollision() || target.getClass() == NullEntity.class) controller.getPlayer().getPosition().down();
    }
}
