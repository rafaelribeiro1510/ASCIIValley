package com.g64.controller.action;

import com.g64.controller.GameController;
import com.g64.exceptions.CrossedDown;
import com.g64.exceptions.CrossedLeft;
import com.g64.exceptions.CrossedRight;
import com.g64.exceptions.CrossedUp;

import java.io.IOException;

public class ExitControls implements ActionEvent {

    GameController gameController;

    public ExitControls(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void execute() throws IOException, CrossedDown, CrossedUp, CrossedRight, CrossedLeft {
        gameController.getMapView().getScreen().clear();
        gameController.setGameState(GameController.gameStates.MAIN_MENU);
    }
}
