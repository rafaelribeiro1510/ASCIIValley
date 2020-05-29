package com.g64.model.gameState;

import com.g64.controller.GameController;
import com.g64.controller.action.ActionEvent;
import com.g64.controller.action.ExitControls;
import com.g64.exceptions.*;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public class controlsState implements GameState {

    GameController gameController;

    public controlsState(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void execute(GameController gameController, ActionEvent actionEvent) {
        // draw control menu
        gameController.getControlsView().draw();

        // process action
        try {
            if (actionEvent != null) actionEvent.execute();
        }
        catch (IOException | Died | CrossedRight | CrossedDown | CrossedLeft | CrossedUp e) {
            e.printStackTrace();
        }
    }

    @Override
    public ActionEvent processKey(KeyStroke key) {
        gameController.getMapView().getScreen().clear();

        // any key works
        if (key != null) return new ExitControls(gameController);

        return null;
    }
}
