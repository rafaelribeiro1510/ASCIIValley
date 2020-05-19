package com.g64.controller.action;

import com.g64.controller.GameController;
import com.g64.exceptions.CrossedRight;
import com.g64.model.Position;
import com.g64.model.items.Item;

public class InteractRight implements ActionEvent {
    private final GameController controller;

    public InteractRight(GameController controller) { this.controller = controller; }

    @Override
    public void execute() {
        Item selectedItem = controller.getInventoryModel().getSelectedItem();
        Position target;
        try { target = controller.getPlayer().getPosition().checkRight(GameController.MAP_WIDTH); }
        catch (CrossedRight ignored) { return; }
        if (selectedItem != null) selectedItem.use(controller, target);
    }
}
