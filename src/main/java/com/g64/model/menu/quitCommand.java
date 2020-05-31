package com.g64.model.menu;

import com.g64.controller.GameController;

import java.io.IOException;

public class quitCommand implements MenuCommand {

    GameController gameController;

    public quitCommand(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void execute() {
        // try { gameController.getMapView().getScreen().close(); }
        try { gameController.getDisplay().getScreen().close(); }
        catch (IOException e) { e.printStackTrace(); }

        gameController.setRunning(false);
        System.out.println("\nQuitting");
    }
}
