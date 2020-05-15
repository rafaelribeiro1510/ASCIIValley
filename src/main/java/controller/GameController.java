package controller;

import exceptions.*;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import controller.action.*;
import model.InventoryModel;
import model.MapModel;
import model.entities.Player;
import model.Position;
import view.EntityView;
import view.InventoryView;
import view.MapView;

import java.io.IOException;

public class GameController {

    public static final int MAP_WIDTH = 40;
    public static final int MAP_HEIGHT = 15;

    private static final int frameRate = 60;

    private MapModel mapModel;
    private MapView mapView;
    private Player player;
    private InventoryModel inventoryModel;
    private EntityView entityView;
    private InventoryView inventoryView;

    private boolean running;

    public GameController() {
        this.player = new Player(new Position(MAP_WIDTH/2, MAP_HEIGHT/2), "\u263B", TextColor.ANSI.BLACK);
        this.inventoryModel = new InventoryModel();
        this.mapModel = new MapModel(5,  "resources/temp.csv");
        this.mapView = new MapView(MAP_WIDTH, MAP_HEIGHT + 3);
        this.entityView = new EntityView(mapView.getScreen());
        this.inventoryView = new InventoryView(mapView.getScreen());
        this.running = true;
    }

    public void start() {
        while (running){
            mapView.draw(mapModel);
            inventoryModel.cleanup();
            inventoryView.draw(inventoryModel, player.getCurrentHealth());
            entityView.draw(player, mapModel.thisChunk());
            try {
                processPlayerAction(getActionEventFromKeyboard()); // Update player with keyboard actions
                for (ActionEvent action : mapModel.updateEntities(this)) processEntityAction(action); // Update non-player entities with generated actions
                mapView.getScreen().refresh();
                Thread.sleep(1000/ frameRate);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void processEntityAction(ActionEvent event){
        if (event == null) return;
        try {
            event.execute();
        } catch (IOException | CrossedRight | CrossedDown | CrossedLeft | CrossedUp ignored) { }
    }

    public void processPlayerAction(ActionEvent event){
        if (event == null) return;
        try {
            event.execute();
        }
        catch (IOException e){
            e.printStackTrace();
        } catch (CrossedUp crossedUp) {
            mapModel.moveNorth();
            player.setPosition(new Position(player.getPosition().getX(), MAP_HEIGHT - 1));
        } catch (CrossedLeft crossedLeft) {
            mapModel.moveWest();
            player.setPosition(new Position(MAP_WIDTH - 1, player.getPosition().getY()));
        } catch (CrossedDown crossedDown) {
            mapModel.moveSouth();
            player.setPosition(new Position(player.getPosition().getX(), 0));
        } catch (CrossedRight crossedRight) {
            mapModel.moveEast();
            player.setPosition(new Position(0, player.getPosition().getY()));
        }
    }

    public ActionEvent getActionEventFromKeyboard() throws IOException{
        Screen screen = mapView.getScreen();
        KeyStroke key = screen.pollInput();
        if (key == null) return null;
        if (key.getKeyType() == KeyType.Escape) return new QuitGame(this);
        if (key.getKeyType() == KeyType.ArrowUp) return new InteractUp(this);
        if (key.getKeyType() == KeyType.ArrowDown) return new InteractDown(this);
        if (key.getKeyType() == KeyType.ArrowLeft) return new InteractLeft(this);
        if (key.getKeyType() == KeyType.ArrowRight) return new InteractRight(this);

        if (key.getCharacter() >= '0' && key.getCharacter() <= '9') return new SelectSlot(this, (Character.getNumericValue(key.getCharacter()) - 1) % 10);

        if (key.getCharacter() == 'w') return new MoveUp(this, player);
        if (key.getCharacter() == 'd') return new MoveRight(this, player);
        if (key.getCharacter() == 's') return new MoveDown(this, player);
        if (key.getCharacter() == 'a') return new MoveLeft(this, player);
        return null;
    }

    public void setRunning(boolean running){ this.running = running; }

    public Player getPlayer(){ return player; }

    public MapModel getMapModel() { return mapModel; }

    public MapView getMapView() { return mapView; }

    public InventoryModel getInventoryModel() { return inventoryModel; }
}
