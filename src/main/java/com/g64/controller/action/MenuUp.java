package com.g64.controller.action;

import com.g64.model.gameState.MainMenuGameState;

public class MenuUp implements ActionEvent {
    private MainMenuGameState state;

    public MenuUp(MainMenuGameState state) { this.state = state; }

    @Override
    public void execute() {
        int newSelected = state.getSelectedOption() - 1 < 0 ?
                state.getSelectedOption() : state.getSelectedOption() - 1;

        state.setSelectedOption(newSelected);
    }
}