package com.g64.controller.action;

import com.g64.controller.GameController;
import com.g64.model.MenuModel;
import com.g64.model.gameState.menuGameState;
import com.g64.model.entities.EntityModel;

import java.io.IOException;

public class EnterPressed implements ActionEvent {

    private menuGameState state;
    private GameController gameController;

    public EnterPressed(menuGameState state, GameController gameController) {
        this.state = state;
        this.gameController = gameController;
    }

    @Override
    public void execute() {
        this.state.getMenuOptions().get(this.state.getSelectedOption()).getMenuCommand().execute();
    }
}
