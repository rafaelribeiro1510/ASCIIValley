package com.g64.controller.Commands;

import com.g64.controller.GameController;

public class PlayCommand implements Command {

    GameController gameController;

    public PlayCommand(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void execute() {
        gameController.setGameState(gameController.getInGameState());
    }
}
