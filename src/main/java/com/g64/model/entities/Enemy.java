package com.g64.model.entities;

import com.googlecode.lanterna.TextColor;
import com.g64.controller.GameController;
import com.g64.controller.action.ActionEvent;
import com.g64.model.Position;
import com.g64.model.items.drops.Drop;

public abstract class Enemy extends EntityModel {
    protected static final int AGGROED_COOLDOWN = 30;
    protected static final int NOT_AGGROED_COOLDOWN = 60;

    boolean aggroed;
    int movementCooldown;

    int attackValue;

    public Enemy(Position position, String string, TextColor color, boolean collision, Drop[] drops, int maxHealth, int attackValue) {
        super(position, string, color, collision, drops, maxHealth);
        this.aggroed = false;
        this.movementCooldown = NOT_AGGROED_COOLDOWN;
        this.attackValue = attackValue;
    }

    public abstract ActionEvent move(GameController controller);

    public abstract void checkForPlayer(Player player);

    public abstract ActionEvent tryMoving(GameController controller);

    public int getAttackValue() {
        return attackValue;
    }
}
