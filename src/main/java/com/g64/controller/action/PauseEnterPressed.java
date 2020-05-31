package com.g64.controller.action;

import com.g64.model.gameState.PauseMenuState;

public class PauseEnterPressed implements ActionEvent {

    private PauseMenuState state;

    public PauseEnterPressed(PauseMenuState state) { this.state = state; }

    @Override
    public void execute() {
        this.state.getMenuOptions().get(this.state.getSelectedOption()).getMenuCommand().execute();
    }
}
