package com.g64.controller.action;

import com.g64.controller.GameController;
import com.g64.exceptions.CrossedDown;
import com.g64.exceptions.RemoveFromInventory;
import com.g64.model.Position;
import com.g64.model.items.Item;

public class InteractDown implements ActionEvent {
    private final GameController controller;

    public InteractDown(GameController controller) { this.controller = controller; }

    @Override
    public void execute() {
        Item selectedItem = controller.getInventoryModel().getSelectedItem();
        Position target;
        try { target = controller.getPlayer().getPosition().checkDown(GameController.MAP_HEIGHT); }
        catch (CrossedDown ignored) { return; }
        if (selectedItem != null) {
            controller.getMapView().blink(target);
            try { selectedItem.use(controller, target); }
            catch (RemoveFromInventory removeFromInventory) { controller.getInventoryModel().getItems().remove(selectedItem); }
        }
    }
}
