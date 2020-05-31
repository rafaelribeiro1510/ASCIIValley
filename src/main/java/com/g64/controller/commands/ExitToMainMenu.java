package com.g64.controller.commands;

import com.g64.controller.GameController;

public class ExitToMainMenu implements Command {
    GameController gameController;

    public ExitToMainMenu(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void execute() {
        gameController.getDisplay().getScreen().clear();
        gameController.setGameState(gameController.getMenuGameState());
    }
}