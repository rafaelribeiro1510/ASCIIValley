package com.g64.model.menu;

import com.g64.controller.GameController;
import com.g64.model.gameState.InGameState;

public class playCommand implements MenuCommand {

    GameController gameController;

    public playCommand(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void execute() {
        // gameController.setGameState(new InGameState(gameController));
        gameController.setGameState(gameController.getInGameState());
    }
}
