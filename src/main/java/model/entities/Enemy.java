package model.entities;

import com.googlecode.lanterna.TextColor;
import controller.GameController;
import controller.action.ActionEvent;
import model.Position;
import model.items.drops.Drop;

public abstract class Enemy extends EntityModel {
    protected static final int AGGROED_COOLDOWN = 30;
    protected static final int NOT_AGGROED_COOLDOWN = 60;

    boolean aggroed;
    int movementCooldown;

    public Enemy(Position position, String string, TextColor color, boolean collision, Drop[] drops, int maxHealth) {
        super(position, string, color, collision, drops, maxHealth);
        this.aggroed = false;
        this.movementCooldown = NOT_AGGROED_COOLDOWN;
    }

    public abstract ActionEvent move(GameController controller);

    public abstract void checkForPlayer(Player player);

    public abstract ActionEvent tryMoving(GameController controller);
}
