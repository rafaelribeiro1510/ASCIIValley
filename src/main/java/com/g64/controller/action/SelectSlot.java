package com.g64.controller.action;

import com.g64.controller.GameController;
import com.g64.model.entities.EntityModel;

public class SelectSlot implements ActionEvent {
    private final GameController controller;
    private final int slot;

    public SelectSlot(GameController controller, int slot) {
        this.controller = controller;
        this.slot = slot;
    }

    @Override
    public void execute(){
        controller.getInventoryModel().setSelectedItem(slot);
    }
}
