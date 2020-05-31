package com.g64.controller.action;

import com.g64.controller.GameController;

public class ExitToMainMenu implements ActionEvent {
    GameController gameController;

    public ExitToMainMenu(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void execute() {
        // gameController.getMapView().getScreen().clear();
        gameController.getDisplay().getScreen().clear();
        // gameController.setGameState(new MainMenuGameState(gameController));
        gameController.setGameState(gameController.getMenuGameState());
    }
}
