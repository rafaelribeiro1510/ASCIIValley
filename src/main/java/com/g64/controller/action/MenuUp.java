package com.g64.controller.action;

import com.g64.model.MenuModel;

import java.io.IOException;

public class MenuUp implements ActionEvent {

    MenuModel menuModel;

    public MenuUp(MenuModel menuModel) { this.menuModel = menuModel; }

    @Override
    public void execute() {
        int newSelected = menuModel.getSelectedOption() - 1 < 0 ?
                menuModel.getSelectedOption() : menuModel.getSelectedOption() - 1;

        menuModel.setSelectedOption(newSelected);
    }
}