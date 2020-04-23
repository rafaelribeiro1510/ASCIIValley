import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import javafx.geometry.Pos;
import model.MapModel;
import model.Position;
import model.entities.Player;
import view.MapView;
import controller.MapController;

import java.io.IOException;

public class Game {
    private static final int MAP_WIDTH = 60;
    private static final int MAP_HEIGHT = 30;

    public static void main(String[] args) throws IOException {
        Player player = new Player(new Position(30, 15), new TextCharacter('H'), TextColor.ANSI.BLUE, TextColor.ANSI.YELLOW);
        MapModel map = new MapModel(MAP_WIDTH, MAP_HEIGHT, player);
        MapView gui = new MapView(MAP_WIDTH, MAP_HEIGHT);
        MapController controller = new MapController(map, gui);
        controller.start();
    }

}
