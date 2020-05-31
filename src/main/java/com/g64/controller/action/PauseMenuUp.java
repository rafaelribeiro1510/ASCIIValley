package com.g64.controller.action;

import com.g64.model.gameState.PauseMenuState;

public class PauseMenuUp implements ActionEvent {

    private PauseMenuState state;

    public PauseMenuUp(PauseMenuState state) { this.state = state; }

    @Override
    public void execute() {
        int newSelected = state.getSelectedOption() - 1 < 0 ?
                state.getSelectedOption() : state.getSelectedOption() - 1;

        state.setSelectedOption(newSelected);
    }
}
