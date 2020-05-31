package com.g64.controller.action;

import com.g64.model.gameState.MainMenuGameState;
import com.g64.model.gameState.MenuGameState;

public class EnterPressed implements ActionEvent {

    private MenuGameState state;

    public EnterPressed(MenuGameState state) {
        this.state = state;
    }

    @Override
    public void execute() {
        this.state.getMenuOptions().get(this.state.getSelectedOption()).getMenuCommand().execute();
    }
}
