package model.items;

import controller.GameController;
import exceptions.Broke;
import model.Position;

public abstract class Item {
    protected String name;

    public void use(GameController controller, Position position){
        if (canBeUsed(controller, position)) {
            controller.getMapView().blink(position);
            try {
                this.decrementValue();
            }
            catch (Broke broke) {
                controller.getInventoryModel().getItems().remove(this);
            }
            itemEffectsOnMap(controller, position);
        }
    }

    public String getName(){ return this.name; }

    public abstract int getValue();

    public abstract void decrementValue() throws Broke;

    public abstract boolean canBeUsed(GameController controller, Position position);

    public abstract void itemEffectsOnMap(GameController controller, Position position);

}
