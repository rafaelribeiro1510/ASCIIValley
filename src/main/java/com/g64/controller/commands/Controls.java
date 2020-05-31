package com.g64.controller.commands;

import com.g64.controller.GameController;

public class Controls implements Command {
    GameController gameController;

    public Controls(GameController gameController) { this.gameController = gameController; }

    @Override
    public void execute() {
        gameController.setGameState(gameController.getControlsState());
    }

}
