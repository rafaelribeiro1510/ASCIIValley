package controller.action;

import controller.GameController;
import exceptions.CrossedDown;
import model.Position;
import model.items.Item;

public class InteractDown implements ActionEvent {
    private final GameController controller;

    public InteractDown(GameController controller) { this.controller = controller; }

    @Override
    public void execute() {
        Item selectedItem = controller.getInventoryModel().getSelectedItem();
        Position target;
        try { target = controller.getPlayer().getPosition().checkDown(GameController.MAP_HEIGHT); }
        catch (CrossedDown ignored) { return; }
        if (selectedItem != null) selectedItem.use(controller, target);
    }
}
