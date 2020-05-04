package controller.action;

import controller.GameController;
import exceptions.CrossedUp;
import model.Position;
import model.items.Item;

public class InteractUp implements ActionEvent{
    private final GameController controller;

    public InteractUp(GameController controller) { this.controller = controller; }

    @Override
    public void execute() {
        Item selectedItem = controller.getInventoryModel().getSelectedItem();
        Position target;
        try { target = controller.getPlayer().getPosition().checkUp(GameController.MAP_HEIGHT); }
        catch (CrossedUp ignored) { return; }
        if (selectedItem != null) selectedItem.use(controller, target);
    }
}
