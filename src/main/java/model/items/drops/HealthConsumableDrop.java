package model.items.drops;

import controller.GameController;
import model.Position;

public class HealthConsumableDrop extends Drop {
    public HealthConsumableDrop(){
        super("HLTH");
    }

    @Override
    public void use(GameController controller, Position position) {
        controller.getPlayer().addHealth(10);
    }
}
