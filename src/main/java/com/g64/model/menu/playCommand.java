package com.g64.model.menu;

import com.g64.controller.GameController;
import com.g64.model.gameState.inGameState;

public class playCommand implements MenuCommand {

    GameController gameController;

    public playCommand(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void execute() {
        gameController.setGameState(new inGameState(gameController));
    }
}
