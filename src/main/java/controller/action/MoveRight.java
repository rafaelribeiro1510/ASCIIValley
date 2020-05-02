package controller.action;

import Exceptions.CrossedEast;
import controller.GameController;
import model.MapEntityModel;
import model.MapModel;

public class MoveRight implements ActionEvent {
    private final GameController controller;
    private final MapModel map;

    public MoveRight(GameController controller, MapModel map) { this.controller = controller; this.map = map; }

    @Override
    public void execute() throws CrossedEast {
        MapEntityModel target = map.thisChunk().getEntityAt(controller.getPlayer().getPosition().checkRight(GameController.MAP_WIDTH));
        if (!target.hasCollision()) controller.getPlayer().getPosition().right();
    }
}
