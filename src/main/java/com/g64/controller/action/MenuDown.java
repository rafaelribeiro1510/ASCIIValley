package com.g64.controller.action;

import com.g64.model.gameState.menuGameState;

public class MenuDown implements ActionEvent {
    private menuGameState state;

    public MenuDown(menuGameState state) { this.state = state; }

    @Override
    public void execute() {
        int newSelected = state.getSelectedOption() + 1 > state.getMenuOptions().size() - 1 ?
                state.getSelectedOption() : state.getSelectedOption() + 1;

        state.setSelectedOption(newSelected);
    }
}
