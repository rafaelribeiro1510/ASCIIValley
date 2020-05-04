package model.items;

import controller.GameController;
import model.Position;

public abstract class Item {
    String name;

    public abstract void use(GameController controller, Position position);
}
