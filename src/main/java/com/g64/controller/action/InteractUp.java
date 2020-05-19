package com.g64.controller.action;

import com.g64.controller.GameController;
import com.g64.exceptions.CrossedUp;
import com.g64.model.Position;
import com.g64.model.items.Item;

public class InteractUp implements ActionEvent{
    private final GameController controller;

    public InteractUp(GameController controller) { this.controller = controller; }
    //TODO Trocar Exceptions por returns
    @Override
    public void execute() {
        Item selectedItem = controller.getInventoryModel().getSelectedItem();
        Position target;
        try { target = controller.getPlayer().getPosition().checkUp(GameController.MAP_HEIGHT); }
        catch (CrossedUp ignored) { return; }
        if (selectedItem != null) selectedItem.use(controller, target);
    }
}
