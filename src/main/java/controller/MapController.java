package controller;

import model.MapModel;
import view.MapView;

import java.io.IOException;

public class MapController {
    private MapModel map;
    private MapView gui;

    public MapController(MapModel map, MapView gui) {
        this.map = map;
        this.gui = gui;
    }

    public void start() throws IOException {
        while (true){

            //Update entities
            gui.drawMap(map);

            //Get commands
            MapView.COMMAND command = gui.getCommand();
            map.getPlayer().updatePosition(command);
        }
    }
}
