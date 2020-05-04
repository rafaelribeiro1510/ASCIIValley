package controller.action;

import controller.GameController;
import exceptions.CrossedLeft;
import model.Position;
import model.items.Item;

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
