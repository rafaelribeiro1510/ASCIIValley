package com.g64.controller;

import com.g64.controller.action.ActionEvent;
import com.g64.model.InventoryModel;
import com.g64.model.MapModel;
import com.g64.model.Position;
import com.g64.model.entities.Player;
import com.g64.model.gameState.*;
import com.g64.view.Display;
import com.g64.view.MapView;
import com.g64.view.MenuView;
import com.g64.view.PauseMenuView;
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
    // private MenuView menuView;
    private PauseMenuView pauseMenuView;


    private GameState gameState;

    private GameState controlsState;
    private GameState deadPlayerState;
    private GameState inGameState;
    private GameState menuGameState;
    private GameState pauseState;


    public GameController() {
        this.mapModel = new MapModel(5,  "resources/chunks.csv");
        this.display = new Display(mapModel.thisChunk().getWidth(), mapModel.thisChunk().getHeight() + 3);
        this.mapView = new MapView(display.getScreen());
        this.player = new Player(new Position(mapModel.thisChunk().getWidth()/2, mapModel.thisChunk().getHeight()/2), "\u263B", TextColor.ANSI.BLACK);
        this.inventoryModel = new InventoryModel();
        this.running = true;
        // this.menuView = new MenuView(display.getScreen());
        this.pauseMenuView = new PauseMenuView(display.getScreen());

        this.controlsState = new ControlsState(this);
        this.deadPlayerState = new DeadPlayerState(this);
        this.inGameState = new InGameState(this);
        this.menuGameState = new MainMenuGameState(this);
        this.pauseState = new PauseMenuState(this);

        gameState = menuGameState;
    }

    public GameController(Player player, Display display, MapModel mapModel, MapView mapView, InventoryModel inventoryModel){
        this.player = player;
        this.display = display;
        this.mapModel = mapModel;
        this.mapView = mapView;
        this.inventoryModel = inventoryModel;
    }

    public void start() {
        while (running) {
            try {
                display.getScreen().refresh();
                processAction(getActionEventFromKeyboard());
                gameState.execute();

                Thread.sleep(1000/ frameRate);
            }
            catch (IOException | InterruptedException e) { e.printStackTrace(); }
        }
    }

    public void processAction(ActionEvent actionEvent){
        actionEvent.execute();
    }

    public ActionEvent getActionEventFromKeyboard() throws IOException{
        Screen screen = display.getScreen();
        KeyStroke key = screen.pollInput();

        return gameState.processKey(key);
    }


    public void setRunning(boolean running){ this.running = running; }

    public Player getPlayer(){ return player; }

    public MapModel getMapModel() { return mapModel; }

    public MapView getMapView() { return mapView; }

    public InventoryModel getInventoryModel() { return inventoryModel; }

    // public MenuView getMenuView() { return menuView; }

    public PauseMenuView getPauseMenuView() { return pauseMenuView; }

    public void setGameState(GameState gameState) { this.gameState = gameState; }

    public Display getDisplay() { return display; }

    public GameState getGameState() { return gameState; }

    public GameState getControlsState() { return controlsState; }

    public GameState getDeadPlayerState() { return deadPlayerState; }

    public GameState getInGameState() { return inGameState; }

    public GameState getMenuGameState() { return menuGameState; }

    public GameState getPauseState() { return pauseState; }

    public void setControlsState(GameState controlsState) {
        this.controlsState = controlsState;
    }

    public void setDeadPlayerState(GameState deadPlayerState) {
        this.deadPlayerState = deadPlayerState;
    }

    public void setInGameState(GameState inGameState) {
        this.inGameState = inGameState;
    }

    public void setMenuGameState(GameState menuGameState) {
        this.menuGameState = menuGameState;
    }
}
