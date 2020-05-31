package com.g64.model.menuCommands;

import com.g64.controller.GameController;

public class ControlsCommand implements MenuCommand {

    GameController gameController;

    public ControlsCommand(GameController gameController) { this.gameController = gameController; }

    @Override
    public void execute() {
        gameController.setGameState(gameController.getControlsState());
    }
}
