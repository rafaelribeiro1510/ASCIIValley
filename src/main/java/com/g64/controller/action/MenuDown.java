package com.g64.controller.action;

import com.g64.model.gameState.MainMenuGameState;
import com.g64.model.gameState.MenuGameState;

public class MenuDown implements ActionEvent {
    private MenuGameState state;

    public MenuDown(MenuGameState state) { this.state = state; }

    @Override
    public void execute() {
        int newSelected = state.getSelectedOption() + 1 > state.getMenuOptions().size() - 1 ?
                state.getSelectedOption() : state.getSelectedOption() + 1;

        state.setSelectedOption(newSelected);
    }
}
