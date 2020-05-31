package com.g64.model.menu;

import com.g64.controller.GameController;
import com.g64.model.gameState.ControlsState;

public class controlsCommand implements MenuCommand {

    GameController gameController;

    public controlsCommand(GameController gameController) { this.gameController = gameController; }

    @Override
    public void execute() {
        // gameController.setGameState(new ControlsState(gameController));
        gameController.setGameState(gameController.getControlsState());
    }
}
