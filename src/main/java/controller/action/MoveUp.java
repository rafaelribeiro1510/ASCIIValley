package controller.action;

import Exceptions.CrossedNorth;
import controller.GameController;
import model.MapEntityModel;
import model.MapModel;

public class MoveUp implements ActionEvent {
    private final GameController controller;
    private final MapModel map;

    public MoveUp(GameController controller, MapModel map) { this.controller = controller; this.map = map; }

    @Override
    public void execute() throws CrossedNorth {
        MapEntityModel target = map.thisChunk().getEntityAt(controller.getPlayer().getPosition().checkUp(GameController.MAP_HEIGHT));
        if (!target.hasCollision()) controller.getPlayer().getPosition().up();
    }
}
