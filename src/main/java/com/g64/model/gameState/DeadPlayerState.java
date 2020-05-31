package com.g64.model.gameState;

import com.g64.controller.GameController;
import com.g64.controller.commands.Command;
import com.g64.controller.commands.Null;
import com.g64.controller.commands.Quit;
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
        deadView.draw();
    }

    @Override
    public Command keyStrokeToActionEvent(KeyStroke key) {
        gameController.getDisplay().getScreen().clear();

        // any key works
        if (key != null) return new Quit(gameController);

        return new Null();
    }
}
