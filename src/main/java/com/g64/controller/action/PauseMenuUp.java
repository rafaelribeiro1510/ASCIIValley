package com.g64.controller.action;

import com.g64.model.gameState.PauseState;

public class PauseMenuUp implements ActionEvent {

    private PauseState state;

    public PauseMenuUp(PauseState state) { this.state = state; }

    @Override
    public void execute() {
        int newSelected = state.getSelectedOption() - 1 < 0 ?
                state.getSelectedOption() : state.getSelectedOption() - 1;

        state.setSelectedOption(newSelected);
    }
}
