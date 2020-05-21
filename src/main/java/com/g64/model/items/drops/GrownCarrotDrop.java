package com.g64.model.items.drops;

import com.g64.controller.GameController;
import com.g64.model.Position;

public class GrownCarrotDrop extends Drop {
    public GrownCarrotDrop() {
        super("CRRT");
    }

    @Override
    public boolean canBeUsed(GameController controller, Position position) {
        return true;
    }

    @Override
    public void itemEffectsOnMap(GameController controller, Position position) {
        controller.getPlayer().addHealth(5);
    }
}
