package com.g64.controller.commands;

import com.g64.model.gameState.MenuGameState;

public class EnterPressed implements Command {

    private MenuGameState state;

    public EnterPressed(MenuGameState state) {
        this.state = state;
    }

    @Override
    public void execute() {
        this.state.getMenuOptions().get(this.state.getSelectedOption()).getCommand().execute();
    }
}
