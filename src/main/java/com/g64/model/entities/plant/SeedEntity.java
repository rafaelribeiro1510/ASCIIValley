package com.g64.model.entities.plant;

import com.g64.controller.GameController;
import com.g64.controller.Commands.Command;
import com.g64.controller.Commands.Grew;
import com.g64.controller.Commands.NullAction;
import com.g64.model.Position;
import com.g64.model.items.drops.Drop;
import com.googlecode.lanterna.TextColor;

public abstract class SeedEntity extends PlantEntity {
    int growth;

    public abstract PlantEntity getGrownEntity();

    public SeedEntity(Position position, String string, TextColor color, boolean collision, Drop[] drops, int maxHealth, int maxGrowth) {
        super(position, string, color, collision, drops, maxHealth);
        growth = maxGrowth;
    }

    @Override
    public Command update(GameController controller) {
        growth--;
        if (growth <= 0) {
            return new Grew(controller, this, this.getGrownEntity());
        }
        return new NullAction();
    }

    public void water(int value){
        growth -= value;
    }
}
