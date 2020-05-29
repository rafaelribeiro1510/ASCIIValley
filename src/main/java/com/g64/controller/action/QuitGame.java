package com.g64.controller.action;

import com.g64.controller.GameController;

import java.io.IOException;


public class QuitGame implements ActionEvent {
    private final GameController controller;

    public QuitGame(GameController controller) { this.controller = controller; }

    @Override
    public void execute() {
        try { controller.getMapView().getScreen().close(); }
        catch (IOException e) { e.printStackTrace(); }
        controller.setRunning(false);
        System.out.println("\nQuitting");
    }
}
