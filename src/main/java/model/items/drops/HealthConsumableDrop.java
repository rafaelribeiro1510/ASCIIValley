package model.items.drops;

import controller.GameController;
import model.Position;

public class HealthConsumableDrop extends Drop {
    public HealthConsumableDrop(){
        super("HLTH");
    }

    @Override
    public boolean canBeUsed(GameController controller, Position position) {
        return true;
    }

    @Override
    public void itemEffectsOnMap(GameController controller, Position position) {
        controller.getPlayer().addHealth(10);
    }
}
