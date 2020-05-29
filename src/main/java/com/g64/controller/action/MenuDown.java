package com.g64.controller.action;

import com.g64.model.MenuModel;
import com.g64.model.gameState.menuGameState;
import com.g64.model.entities.EntityModel;

import java.io.IOException;

public class MenuDown implements ActionEvent {

    private menuGameState state;

    public MenuDown(menuGameState state) { this.state = state; }

    @Override
    public void execute() throws IOException, CrossedDown, CrossedUp, CrossedRight, CrossedLeft {
        int newSelected = state.getSelectedOption() + 1 > state.getMenuOptions().size() - 1 ?
                state.getSelectedOption() : state.getSelectedOption() + 1;

        state.setSelectedOption(newSelected);
        /*
        int newSelected = menuModel.getSelectedOption() + 1 > menuModel.getMenuItems().size() - 1 ?
                menuModel.getSelectedOption() : menuModel.getSelectedOption() + 1;

        menuModel.setSelectedOption(newSelected);
        */
    }
}
