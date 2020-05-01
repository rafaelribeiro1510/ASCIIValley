package controller;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import model.EntityModel;
import model.MapModel;
import model.PlayerModel;
import model.Position;
import view.EntityView;
import view.MapView;

import java.io.IOException;

public class GameController {
    public enum COMMAND {UP, RIGHT, DOWN, LEFT, QUIT}

    public static final int MAP_WIDTH = 40;
    public static final int MAP_HEIGHT = 15;

    private MapModel mapModel;
    private MapView mapView;
    PlayerModel playerModel;
    EntityView entityView;

    public GameController() {
        this.playerModel = new PlayerModel(new Position(MAP_WIDTH/2, MAP_HEIGHT/2), "\u263B", TextColor.ANSI.BLACK);
        this.mapModel = new MapModel(MAP_WIDTH, MAP_HEIGHT, 3,  "src/main/java/model/chunks.csv");
        this.mapView = new MapView(MAP_WIDTH, MAP_HEIGHT);
        this.entityView = new EntityView(mapView.getScreen());
    }

    public void start() {
        while (true){
            mapView.drawMap(mapModel);

            //Draw entities here
            entityView.draw(playerModel, mapModel.getChunk().getTerrainColorAt(playerModel.getPosition()));
            try {
                mapView.getScreen().refresh();
            } catch (IOException e) {
                e.printStackTrace();
            }
            getCommand();
        }
    }

    public void getCommand() {
        try {
            Screen screen = mapView.getScreen();
            KeyStroke key = screen.readInput();
            if (key.getKeyType() == KeyType.ArrowUp) playerModel.updatePosition(COMMAND.UP, mapModel);
            if (key.getKeyType() == KeyType.ArrowRight) playerModel.updatePosition(COMMAND.RIGHT, mapModel);
            if (key.getKeyType() == KeyType.ArrowDown) playerModel.updatePosition(COMMAND.DOWN, mapModel);
            if (key.getKeyType() == KeyType.ArrowLeft) playerModel.updatePosition(COMMAND.LEFT, mapModel);
            if (key.getKeyType() == KeyType.Escape) {
                screen.close();
                System.out.println("\nQuitting");
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
