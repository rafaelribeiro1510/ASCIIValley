package model.items.tools;

import controller.GameController;
import model.Position;

public class WateringCan extends Tool{
    public WateringCan() {
        this.name = "CAN";
        this.durability = 100;
    }

    @Override
    public boolean canBeUsed(GameController controller, Position position) {
        return false;
    }

    @Override
    public void itemEffectsOnMap(GameController controller, Position position) {

    }
}
