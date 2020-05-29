package com.g64.model.gameState;

import com.g64.controller.GameController;
import com.g64.controller.action.ActionEvent;
import com.g64.controller.action.QuitGame;
import com.g64.exceptions.Died;
import com.g64.view.DeadView;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public class deadPlayerState implements GameState {

    GameController gameController;
    private DeadView deadView;

    public deadPlayerState(GameController gameController) {
        this.gameController = gameController;
        this.deadView = new DeadView(gameController.getDisplay().getScreen());
    }

    @Override
    public void execute(GameController gameController) {
        // draw game over screen
        deadView.draw();
    }

    @Override
    public ActionEvent processKey(KeyStroke key) {
        gameController.getMapView().getScreen().clear();

        // any key works
        if (key != null) return new QuitGame(gameController);

        return null;
    }
}
