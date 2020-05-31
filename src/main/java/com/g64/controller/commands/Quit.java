package com.g64.controller.commands;

import com.g64.controller.GameController;

import java.io.IOException;

public class Quit implements Command {

    GameController gameController;

    public Quit(GameController gameController) {
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
