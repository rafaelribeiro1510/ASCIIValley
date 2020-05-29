package com.g64.controller.action;

import com.g64.controller.GameController;
import com.g64.model.gameState.menuGameState;

public class ExitToMainMenu implements ActionEvent {

    GameController gameController;

    public ExitToMainMenu(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void execute() {
        gameController.getMapView().getScreen().clear();
        gameController.setGameState(new menuGameState(gameController));
        // gameController.setGameState(GameController.gameStates.MAIN_MENU);
    }
}
