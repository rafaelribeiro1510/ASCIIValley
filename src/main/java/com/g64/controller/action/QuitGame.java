package com.g64.controller.action;

import com.g64.controller.GameController;
import com.g64.model.entities.EntityModel;

import java.io.IOException;

public class QuitGame implements ActionEvent {
    private final GameController controller;

    public QuitGame(GameController controller) { this.controller = controller; }

    @Override
    public void execute() throws IOException {
        controller.getMapView().getScreen().close();
        controller.setRunning(false);
        System.out.println("\nQuitting");
    }
}
