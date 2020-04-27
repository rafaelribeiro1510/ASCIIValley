package controller;

import model.map.MapModel;
import view.MapView;

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

            //Get commands ; not finished
            MapView.COMMAND command = view.getCommand();

            if (command == MapView.COMMAND.QUIT) {
                System.out.println("\nQuitting");
                break;
            }

            model.getPlayerModel().updatePosition(command);
        }
    }
}
