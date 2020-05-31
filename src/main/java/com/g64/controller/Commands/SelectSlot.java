package com.g64.controller.Commands;

import com.g64.controller.GameController;

public class SelectSlot implements Command {
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
