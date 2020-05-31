package com.g64.controller.commands;

import com.g64.controller.GameController;

public class Play implements Command {

    GameController gameController;

    public Play(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void execute() {
        gameController.setGameState(gameController.getInGameState());
    }
}
