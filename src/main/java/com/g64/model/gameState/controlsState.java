package com.g64.model.gameState;

import com.g64.controller.GameController;
import com.g64.controller.action.ActionEvent;
import com.g64.controller.action.ExitToMainMenu;
import com.g64.controller.action.NullAction;
import com.g64.view.ControlsView;
import com.googlecode.lanterna.input.KeyStroke;


public class controlsState implements GameState {
    GameController gameController;
    ControlsView controlsView;

    public controlsState(GameController gameController) {
        this.gameController = gameController;
        this.controlsView = new ControlsView(gameController.getDisplay().getScreen());
    }

    @Override
    public void execute() {
        // draw control menu
        controlsView.draw();
    }

    @Override
    public ActionEvent processKey(KeyStroke key) {
        gameController.getMapView().getScreen().clear();

        // any key works
        if (key != null) return new ExitToMainMenu(gameController);

        return new NullAction();
    }
}
