import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import model.map.MapModel;
import model.Position;
import model.entities.Player;
import view.map.MapView;
import controller.MapController;

import java.io.IOException;

public class Game {
    private static final int MAP_WIDTH = 40;
    private static final int MAP_HEIGHT = 15;

    public static void main(String[] args) throws IOException {
        Player player = new Player(new Position(30, 15), new TextCharacter('H'), TextColor.ANSI.BLUE, TextColor.ANSI.YELLOW);
        MapModel map = new MapModel(MAP_WIDTH, MAP_HEIGHT, player, 0);
        MapView gui = new MapView(MAP_WIDTH, MAP_HEIGHT);
        MapController controller = new MapController(map, gui);
        controller.start();
    }

}
