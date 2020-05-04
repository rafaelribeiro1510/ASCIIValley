package controller.action;

import controller.GameController;
import exceptions.CrossedRight;
import model.Position;
import model.items.Item;

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
