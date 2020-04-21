import data.MapModel;
import gui.MapView;
import rules.MapController;

import java.io.IOException;

public class Game {
    private static final int MAP_WIDTH = 60;
    private static final int MAP_HEIGHT = 30;

    public static void main(String[] args) throws IOException {
        MapModel map = new MapModel(MAP_WIDTH, MAP_HEIGHT);
        MapView gui = new MapView(MAP_WIDTH, MAP_HEIGHT);
        MapController controller = new MapController(map, gui);
        controller.start();
    }

}
