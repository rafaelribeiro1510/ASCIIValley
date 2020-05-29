package com.g64.controller.action;

import com.g64.model.MenuModel;
import com.g64.model.gameState.menuGameState;
import com.g64.model.entities.EntityModel;

import java.io.IOException;

public class MenuUp implements ActionEvent {

    private menuGameState state;

    public MenuUp(menuGameState state) { this.state = state; }

    @Override
    public void execute() throws IOException, CrossedDown, CrossedUp, CrossedRight, CrossedLeft {
        int newSelected = state.getSelectedOption() - 1 < 0 ?
                state.getSelectedOption() : state.getSelectedOption() - 1;

        state.setSelectedOption(newSelected);
    }
}