package controller;

import Exceptions.CrossedEast;
import Exceptions.CrossedNorth;
import Exceptions.CrossedSouth;
import Exceptions.CrossedWest;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import controller.action.*;
import model.MapModel;
import model.PlayerModel;
import model.Position;
import view.EntityView;
import view.MapView;

import java.io.IOException;

public class GameController {

    public static final int MAP_WIDTH = 40;
    public static final int MAP_HEIGHT = 15;

    private MapModel mapModel;
    private MapView mapView;
    private PlayerModel playerModel;
    private EntityView entityView;

    private boolean running;

    public GameController() {
        this.playerModel = new PlayerModel(new Position(MAP_WIDTH/2, MAP_HEIGHT/2), "\u263B", TextColor.ANSI.BLACK, true);
        this.mapModel = new MapModel(MAP_WIDTH, MAP_HEIGHT, 1,  "src/main/java/model/chunks.csv");
        this.mapView = new MapView(MAP_WIDTH, MAP_HEIGHT);
        this.entityView = new EntityView(mapView.getScreen());
        this.running = true;
    }

    public void start() {
        while (running){
            mapView.drawMap(mapModel);

            entityView.draw(playerModel, mapModel.thisChunk().getTerrainColorAt(playerModel.getPosition()));
            try {
                mapView.getScreen().refresh();
                processKey(getActionEvent());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void processKey(ActionEvent event){
        if (event == null) return;
        try {
            event.execute();
        }
        catch (IOException e){
            e.printStackTrace();
        } catch (CrossedNorth crossedNorth) {
            mapModel.moveNorth();
            playerModel.setPosition(new Position(playerModel.getPosition().getX(), MAP_HEIGHT - 1));
        } catch (CrossedWest crossedWest) {
            mapModel.moveWest();
            playerModel.setPosition(new Position(MAP_WIDTH - 1, playerModel.getPosition().getY()));
        } catch (CrossedSouth crossedSouth) {
            mapModel.moveSouth();
            playerModel.setPosition(new Position(playerModel.getPosition().getX(), 0));
        } catch (CrossedEast crossedEast) {
            mapModel.moveEast();
            playerModel.setPosition(new Position(0, playerModel.getPosition().getY()));
        }
    }

    public ActionEvent getActionEvent() throws IOException{
        Screen screen = mapView.getScreen();
        KeyStroke key = screen.readInput();
        if (key.getKeyType() == KeyType.Escape) return new QuitGame(this);
        if (key.getKeyType() == KeyType.ArrowUp) return new InteractUp(this);
        if (key.getKeyType() == KeyType.ArrowDown) return new InteractDown(this);
        if (key.getKeyType() == KeyType.ArrowLeft) return new InteractLeft(this);
        if (key.getKeyType() == KeyType.ArrowRight) return new InteractRight(this);
        if (key.getCharacter() == 'w') return new MoveUp(this);
        if (key.getCharacter() == 'd') return new MoveRight(this);
        if (key.getCharacter() == 's') return new MoveDown(this);
        if (key.getCharacter() == 'a') return new MoveLeft(this);
        return null;
    }

    public void setRunning(boolean running){ this.running = running; }

    public PlayerModel getPlayer(){ return playerModel; }

    public MapModel getMapModel() { return mapModel; }

    public MapView getMapView() { return mapView; }
}
