package com.g64.controller.action;

import com.g64.model.gameState.PauseState;

public class PauseMenuDown implements ActionEvent {

    private PauseState state;

    public PauseMenuDown(PauseState state) {
        this.state = state;
    }

    @Override
    public void execute() {
        int newSelected = state.getSelectedOption() + 1 > state.getMenuOptions().size() - 1 ?
                state.getSelectedOption() : state.getSelectedOption() + 1;

        state.setSelectedOption(newSelected);
    }
}
