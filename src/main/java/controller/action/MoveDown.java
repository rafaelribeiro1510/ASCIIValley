package controller.action;

import Exceptions.CrossedSouth;
import controller.GameController;
import model.MapEntityModel;
import model.MapModel;

public class MoveDown implements ActionEvent {
    private final GameController controller;
    private final MapModel map;

    public MoveDown(GameController controller, MapModel map) { this.controller = controller; this.map = map; }

    @Override
    public void execute() throws CrossedSouth {
        MapEntityModel target = map.thisChunk().getEntityAt(controller.getPlayer().getPosition().checkDown(GameController.MAP_HEIGHT));
        if (!target.hasCollision()) controller.getPlayer().getPosition().down();
    }
}
