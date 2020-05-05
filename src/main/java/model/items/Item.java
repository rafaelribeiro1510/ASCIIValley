package model.items;

import controller.GameController;
import model.Position;

public abstract class Item {
    String name;
    int durability;

    public String getName(){ return this.name; }

    public int getDurability() { return durability; }

    public abstract void use(GameController controller, Position position);

    public void decrementDurability(){ if (durability > 0) durability--; }
}
