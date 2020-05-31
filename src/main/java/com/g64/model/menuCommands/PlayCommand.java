package com.g64.model.menuCommands;

import com.g64.controller.GameController;

public class PlayCommand implements MenuCommand {

    GameController gameController;

    public PlayCommand(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void execute() {
        // gameController.setGameState(new InGameState(gameController));
        gameController.setGameState(gameController.getInGameState());
    }
}
