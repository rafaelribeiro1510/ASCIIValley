package com.g64.model.gameState;

import com.g64.controller.GameController;
import com.g64.controller.Commands.Command;
import com.g64.controller.Commands.ControlsCommand;
import com.g64.controller.Commands.NullAction;
import com.g64.view.ControlsView;
import com.googlecode.lanterna.input.KeyStroke;


public class ControlsState implements GameState {
    GameController gameController;
    ControlsView controlsView;

    public ControlsState(GameController gameController) {
        this.gameController = gameController;
        this.controlsView = new ControlsView(gameController.getDisplay().getScreen());
    }

    public ControlsState(GameController gameController, ControlsView controlsView) {
        this.gameController = gameController;
        this.controlsView = controlsView;
    }


    @Override
    public void execute() {
        controlsView.draw();
    }

    @Override
    public Command keyStrokeToActionEvent(KeyStroke key) {
        gameController.getDisplay().getScreen().clear();

        // any key works
        if (key != null) return new ControlsCommand.ExitToMainMenu(gameController);

        return new NullAction();
    }
}
