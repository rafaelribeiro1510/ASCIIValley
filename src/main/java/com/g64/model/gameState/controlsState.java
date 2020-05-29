package com.g64.model.gameState;

import com.g64.controller.GameController;
import com.g64.controller.action.ActionEvent;
import com.g64.controller.action.ExitToMainMenu;
import com.googlecode.lanterna.input.KeyStroke;


public class controlsState implements GameState {

    GameController gameController;

    public controlsState(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void execute(GameController gameController) {
        // draw control menu
        gameController.getControlsView().draw();
    }

    @Override
    public ActionEvent processKey(KeyStroke key) {
        gameController.getMapView().getScreen().clear();

        // any key works
        if (key != null) return new ExitToMainMenu(gameController);

        return null;
    }
}
