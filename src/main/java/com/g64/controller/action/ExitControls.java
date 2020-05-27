package com.g64.controller.action;

import com.g64.controller.GameController;
import com.g64.model.entities.EntityModel;

import java.io.IOException;

public class ExitControls implements ActionEvent {

    GameController gameController;

    public ExitControls(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void execute() {
        gameController.getMapView().getScreen().clear();
        gameController.setGameState(GameController.gameStates.MAIN_MENU);
    }

    @Override
    public EntityModel getEntity() {
        return null;
    }
}
