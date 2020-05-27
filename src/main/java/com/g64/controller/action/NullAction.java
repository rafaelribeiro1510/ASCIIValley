package com.g64.controller.action;


import com.g64.model.entities.EntityModel;

public class NullAction implements ActionEvent {
    @Override
    public void execute() {

    }

    @Override
    public EntityModel getEntity() {
        return null;
    }
}
