package controller.action;

import Exceptions.CrossedWest;
import controller.GameController;
import model.MapEntityModel;
import model.MapModel;

public class MoveLeft implements ActionEvent {
    private final GameController controller;
    private final MapModel map;

    public MoveLeft(GameController controller, MapModel map) { this.controller = controller; this.map = map; }

    @Override
    public void execute() throws CrossedWest {
        MapEntityModel target = map.thisChunk().getEntityAt(controller.getPlayer().getPosition().checkLeft(GameController.MAP_WIDTH));
        if (!target.hasCollision()) controller.getPlayer().getPosition().left();
    }
}
