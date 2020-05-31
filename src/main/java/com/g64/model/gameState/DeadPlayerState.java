package com.g64.model.gameState;

import com.g64.controller.GameController;
import com.g64.controller.action.ActionEvent;
import com.g64.controller.action.NullAction;
import com.g64.controller.action.QuitGame;
import com.g64.view.DeadView;
import com.googlecode.lanterna.input.KeyStroke;

public class DeadPlayerState implements GameState {

    GameController gameController;
    private DeadView deadView;

    public DeadPlayerState(GameController gameController) {
        this.gameController = gameController;
        this.deadView = new DeadView(gameController.getDisplay().getScreen());
    }

    public DeadPlayerState(GameController gameController, DeadView deadView) {
        this.gameController = gameController;
        this.deadView = deadView;
    }

    @Override
    public void execute() {
        // draw game over screen
        deadView.draw();
    }

    @Override
    public ActionEvent processKey(KeyStroke key) {
        gameController.getMapView().getScreen().clear();

        // any key works
        if (key != null) return new QuitGame(gameController);

        return new NullAction();
    }
}
