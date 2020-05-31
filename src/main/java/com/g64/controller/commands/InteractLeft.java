package com.g64.controller.commands;

import com.g64.controller.GameController;
import com.g64.model.Position;
import com.g64.model.entities.visitors.ItemVisitor;
import com.g64.model.items.Item;

public class InteractLeft implements Command {
    private final GameController controller;

    public InteractLeft(GameController controller) { this.controller = controller; }

    @Override
    public void execute() {
        Item selectedItem = controller.getInventoryModel().getSelectedItem();
        Position target = controller.getPlayer().getPosition().lookLeft();
        controller.getInventoryModel().useItem(selectedItem, new ItemVisitor(controller, target));
    }
}
