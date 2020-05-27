package com.g64.model.entities.enemy;

import com.g64.exceptions.Died;
import com.g64.model.entities.EntityModel;
import com.g64.model.entities.Player;
import com.g64.model.entities.enemy.MovementHumour.EnemyMovementHumour;
import com.googlecode.lanterna.TextColor;
import com.g64.controller.GameController;
import com.g64.model.Position;
import com.g64.model.items.drops.Drop;

public abstract class Enemy extends EntityModel {
    protected static final int AGGROED_COOLDOWN = 30;
    protected static final int NOT_AGGROED_COOLDOWN = 60;

    EnemyMovementHumour movementHumour;
    int movementCooldown;

    int attackValue;

    public Enemy(Position position, String string, TextColor color, boolean collision, Drop[] drops, int maxHealth, int attackValue) {
        super(position, string, color, collision, drops, maxHealth);
        this.movementCooldown = NOT_AGGROED_COOLDOWN;
        this.attackValue = attackValue;
    }

    public abstract void checkForPlayer(Player player);

    public int getAttackValue() {
        return attackValue;
    }

    @Override
    public void update(GameController controller) throws Died {
        if (movementCooldown == 0) {
            checkForPlayer(controller.getPlayer());
            movementHumour.move(controller);
        }
        else {
            movementCooldown--;
        }
    }
}
