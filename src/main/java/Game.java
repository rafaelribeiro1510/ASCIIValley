import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import model.map.MapModel;
import model.Position;
import model.entities.PlayerModel;
import view.MapView;
import controller.MapController;

import java.io.IOException;

public class Game {
    // TODO #define assim?? vv
    private static final int MAP_WIDTH = 40;
    private static final int MAP_HEIGHT = 15;

    public static void main(String[] args) throws IOException {
        PlayerModel playerModel = new PlayerModel(new Position(MAP_WIDTH/2, MAP_HEIGHT/2), new TextCharacter('H'), TextColor.ANSI.RED);
        MapModel map = new MapModel(MAP_WIDTH, MAP_HEIGHT, playerModel, 1);
        MapView gui = new MapView(MAP_WIDTH, MAP_HEIGHT);
        MapController controller = new MapController(map, gui);
        controller.start();
    }

}
