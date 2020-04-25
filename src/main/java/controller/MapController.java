package controller;

import model.map.MapModel;
import view.map.MapView;

import java.io.IOException;

public class MapController {
    private MapModel model;
    private MapView view;

    public MapController(MapModel model, MapView view) {
        this.model = model;
        this.view = view;
    }

    public void start() throws IOException {
        while (true){

            //Update entities
            view.drawMap(model);

            //Get commands
            MapView.COMMAND command = view.getCommand();
            model.getPlayer().updatePosition(command);
        }
    }
}
