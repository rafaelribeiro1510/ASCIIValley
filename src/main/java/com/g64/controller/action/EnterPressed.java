package com.g64.controller.action;

import com.g64.model.gameState.menuGameState;

public class EnterPressed implements ActionEvent {
    private menuGameState state;

    public EnterPressed(menuGameState state) {
        this.state = state;
    }

    @Override
    public void execute() {
        this.state.getMenuOptions().get(this.state.getSelectedOption()).getMenuCommand().execute();
    }
}
