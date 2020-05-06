package model.items;

import controller.GameController;
import model.Position;

public abstract class Item {
    protected String name;

    public String getName(){ return this.name; }

    public abstract void use(GameController controller, Position position);

    public abstract int getValue();
}
