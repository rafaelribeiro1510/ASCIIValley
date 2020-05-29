package com.g64.controller;

import com.g64.controller.action.ActionEvent;
import com.g64.exceptions.Died;
import com.g64.model.InventoryModel;
import com.g64.model.MapModel;
import com.g64.model.MenuModel;
import com.g64.model.Position;
import com.g64.model.entities.Player;
import com.g64.model.gameState.GameState;
import com.g64.model.gameState.deadPlayerState;
import com.g64.model.gameState.menuGameState;
import com.g64.view.*;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class GameController {

    private static final int frameRate = 60;

    private MapModel mapModel;
    private MapView mapView;
    private Player player;
    private InventoryModel inventoryModel;

    private boolean running;
    private Display display;
    private MenuView menuView;
    private ControlsView controlsView;


    private GameState gameState = new menuGameState(this);

    public GameController() {
        this.mapModel = new MapModel(6,  "resources/chunks.csv");
        this.display = new Display(mapModel.thisChunk().getWidth(), mapModel.thisChunk().getHeight() + 3);
        this.mapView = new MapView(display.getScreen());
        this.player = new Player(new Position(mapModel.thisChunk().getWidth()/2, mapModel.thisChunk().getHeight()/2), "\u263B", TextColor.ANSI.BLACK);
        this.inventoryModel = new InventoryModel();
        this.running = true;
        this.menuView = new MenuView(display.getScreen());
        this.controlsView = new ControlsView(display.getScreen());
    }

    public GameController(Player player, MapModel mapModel, MapView mapView, InventoryModel inventoryModel){
        this.player = player;
        this.mapModel = mapModel;
        this.mapView = mapView;
        this.inventoryModel = inventoryModel;
    }

    public void start() {
        while (running) {
            try {
                mapView.getScreen().refresh();
                processAction(getActionEventFromKeyboard());
                gameState.execute(this);

                Thread.sleep(1000/ frameRate);
            }
            catch (IOException | InterruptedException e) { e.printStackTrace(); }
        }
    }

    public void processAction(ActionEvent actionEvent){
        try {
            if (actionEvent != null) actionEvent.execute();
            for (ActionEvent event : mapModel.updateEntities(this)) {
                event.execute();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (Died died) {
            setGameState(new deadPlayerState(this));
        }
    }

    public ActionEvent getActionEventFromKeyboard() throws IOException{
        Screen screen = mapView.getScreen();
        KeyStroke key = screen.pollInput();

        return gameState.processKey(key);
    }


    public void setRunning(boolean running){ this.running = running; }

    public Player getPlayer(){ return player; }

    public MapModel getMapModel() { return mapModel; }

    public MapView getMapView() { return mapView; }

    public InventoryModel getInventoryModel() { return inventoryModel; }

    public MenuView getMenuView() { return menuView; }

    public void setGameState(GameState gameState) { this.gameState = gameState; }

    public ControlsView getControlsView() { return controlsView; }

    public Display getDisplay() { return display; }
}
