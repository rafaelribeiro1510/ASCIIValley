package com.g64.model.items;

import com.g64.controller.GameController;
import com.g64.exceptions.Broke;
import com.g64.model.Position;

public abstract class Item {
    protected String name;

    public void use(GameController controller, Position position){
        if (canBeUsed(controller, position)) {
            itemEffectsOnMap(controller, position);
            try { this.decrementValue(); }
            catch (Broke broke) { controller.getInventoryModel().getItems().remove(this); }
        }
    }

    public String getName(){ return this.name; }

    public abstract int getValue();

    public abstract void decrementValue() throws Broke;

    public abstract boolean canBeUsed(GameController controller, Position position);

    public abstract void itemEffectsOnMap(GameController controller, Position position);

}