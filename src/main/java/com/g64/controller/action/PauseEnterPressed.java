package com.g64.controller.action;

import com.g64.model.gameState.MenuGameState;
import com.g64.model.gameState.PauseState;

public class PauseEnterPressed implements ActionEvent {

    private PauseState state;

    public PauseEnterPressed(PauseState state) { this.state = state; }

    @Override
    public void execute() {
        this.state.getMenuOptions().get(this.state.getSelectedOption()).getMenuCommand().execute();
    }
}
