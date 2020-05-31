package com.g64.model.menuCommands;

import com.g64.controller.GameController;

import java.io.IOException;

public class QuitCommand implements MenuCommand {

    GameController gameController;

    public QuitCommand(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void execute() {
        try { gameController.getDisplay().getScreen().close(); }
        catch (IOException e) { e.printStackTrace(); }

        gameController.setRunning(false);
        System.out.println("\nQuitting");
    }
}
