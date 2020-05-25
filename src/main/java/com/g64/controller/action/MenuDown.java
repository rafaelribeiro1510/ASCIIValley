package com.g64.controller.action;

import com.g64.exceptions.CrossedDown;
import com.g64.exceptions.CrossedLeft;
import com.g64.exceptions.CrossedRight;
import com.g64.exceptions.CrossedUp;
import com.g64.model.MenuModel;

import java.io.IOException;

public class MenuDown implements ActionEvent {

    MenuModel menuModel;

    public MenuDown(MenuModel menuModel) { this.menuModel = menuModel; }

    @Override
    public void execute() throws IOException, CrossedDown, CrossedUp, CrossedRight, CrossedLeft {
        int newSelected = menuModel.getSelectedOption() + 1 > menuModel.getMenuItems().size() - 1 ?
                menuModel.getSelectedOption() : menuModel.getSelectedOption() + 1;

        menuModel.setSelectedOption(newSelected);
    }
}
