package model.items;

import controller.GameController;
import model.Position;

public class WateringCan extends Item{
    public WateringCan() {
        this.name = "CAN ";
        this.durability = 200;
    }

    @Override
    public void use(GameController controller, Position position) {

    }
}
