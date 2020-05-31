package com.g64.controller.commands;

import com.g64.model.gameState.MenuGameState;

public class MenuUp implements Command {
    private MenuGameState state;

    public MenuUp(MenuGameState state) { this.state = state; }

    @Override
    public void execute() {
        int newSelected = state.getSelectedOption() - 1 < 0 ?
                state.getSelectedOption() : state.getSelectedOption() - 1;

        state.setSelectedOption(newSelected);
    }
}