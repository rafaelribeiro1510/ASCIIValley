package com.g64.controller.action;

import com.g64.controller.GameController;
import com.g64.exceptions.CrossedLeft;
import com.g64.model.Position;
import com.g64.model.items.Item;

public class InteractLeft implements ActionEvent {
    private final GameController controller;

    public InteractLeft(GameController controller) { this.controller = controller; }

    @Override
    public void execute() {
        Item selectedItem = controller.getInventoryModel().getSelectedItem();
        Position target;
        try { target = controller.getPlayer().getPosition().checkLeft(GameController.MAP_WIDTH); }
        catch (CrossedLeft ignored) { return; }
        if (selectedItem != null) selectedItem.use(controller, target);
    }
}
