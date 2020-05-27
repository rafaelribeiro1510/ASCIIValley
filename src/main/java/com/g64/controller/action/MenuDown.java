package com.g64.controller.action;

import com.g64.model.MenuModel;
import com.g64.model.entities.EntityModel;

import java.io.IOException;

public class MenuDown implements ActionEvent {

    MenuModel menuModel;

    public MenuDown(MenuModel menuModel) { this.menuModel = menuModel; }

    @Override
    public void execute() {
        int newSelected = menuModel.getSelectedOption() + 1 > menuModel.getMenuItems().size() - 1 ?
                menuModel.getSelectedOption() : menuModel.getSelectedOption() + 1;

        menuModel.setSelectedOption(newSelected);
    }

    @Override
    public EntityModel getEntity() {
        return null;
    }
}
