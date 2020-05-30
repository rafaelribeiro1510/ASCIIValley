package com.g64.controller.action;

import com.g64.controller.GameController;
import com.g64.model.Position;
import com.g64.model.entities.visitors.TargetVisitor;
import com.g64.model.items.Item;

public class InteractUp implements ActionEvent{
    private final GameController controller;

    public InteractUp(GameController controller) { this.controller = controller; }

    @Override
    public void execute() {
        Item selectedItem = controller.getInventoryModel().getSelectedItem();
        Position target = controller.getPlayer().getPosition().lookUp();
        controller.getInventoryModel().useItem(selectedItem, new TargetVisitor(controller, target));
    }
}
