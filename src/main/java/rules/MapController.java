package rules;

import data.MapModel;
import gui.MapView;

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
            //Get commands
            //Update entities
            gui.drawMap(map);
        }
    }
}
