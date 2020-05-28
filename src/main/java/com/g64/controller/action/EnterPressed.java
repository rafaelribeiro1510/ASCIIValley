package com.g64.controller.action;

import com.g64.controller.GameController;
import com.g64.exceptions.CrossedDown;
import com.g64.exceptions.CrossedLeft;
import com.g64.exceptions.CrossedRight;
import com.g64.exceptions.CrossedUp;
import com.g64.model.MenuModel;
import com.g64.model.gameState.menuGameState;

import java.io.IOException;

public class EnterPressed implements ActionEvent {

    private menuGameState state;
    private GameController gameController;

    public EnterPressed(menuGameState state, GameController gameController) {
        this.state = state;
        this.gameController = gameController;
    }

    @Override
    public void execute() throws IOException, CrossedDown, CrossedUp, CrossedRight, CrossedLeft {

        this.state.getMenuOptions().get(this.state.getSelectedOption()).getMenuCommand().execute();
        /*
        switch(menuModel.getSelectedOption()) {
            case 0:
                gameController.getMapView().getScreen().clear();
                gameController.setGameState(GameController.gameStates.IN_GAME);
                break;
            case 1:
                gameController.getMapView().getScreen().clear();
                gameController.setGameState(GameController.gameStates.CONTROLS);
                break;
            case 2:
                gameController.getMapView().getScreen().close();
                gameController.setRunning(false);
                break;
        }
        */
    }
}
