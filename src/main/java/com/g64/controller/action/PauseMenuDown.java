package com.g64.controller.action;

import com.g64.model.gameState.PauseMenuState;

public class PauseMenuDown implements ActionEvent {

    private PauseMenuState state;

    public PauseMenuDown(PauseMenuState state) {
        this.state = state;
    }

    @Override
    public void execute() {
        int newSelected = state.getSelectedOption() + 1 > state.getMenuOptions().size() - 1 ?
                state.getSelectedOption() : state.getSelectedOption() + 1;

        state.setSelectedOption(newSelected);
    }
}
