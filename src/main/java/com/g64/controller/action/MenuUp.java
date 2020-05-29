package com.g64.controller.action;

import com.g64.model.gameState.menuGameState;

public class MenuUp implements ActionEvent {

    private menuGameState state;

    public MenuUp(menuGameState state) { this.state = state; }

    @Override
    public void execute() {
        int newSelected = state.getSelectedOption() - 1 < 0 ?
                state.getSelectedOption() : state.getSelectedOption() - 1;

        state.setSelectedOption(newSelected);
    }
}