package controller.action;

import controller.GameController;

public class SelectSlot implements ActionEvent {
    private final GameController controller;
    private final int slot;

    public SelectSlot(GameController controller, int slot) { this.controller = controller;
        this.slot = slot;
    }

    @Override
    public void execute(){
        controller.getInventoryModel().setSelectedItem(slot);
    }
}
