package com.g64.controller.action;

import com.g64.controller.GameController;

public class ExitToMainMenu implements ActionEvent {
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
