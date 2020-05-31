package com.g64.model.entities.enemy.humours;

import com.g64.controller.GameController;
import com.g64.controller.Commands.Command;
import com.g64.model.entities.enemy.Enemy;
import com.googlecode.lanterna.TextColor;

public abstract class EnemyHumour {
    protected Enemy me;
    protected int maxCooldown;
    protected TextColor color;

    public EnemyHumour(Enemy me, int maxCooldown, TextColor color) {
        this.me = me;
        this.maxCooldown = maxCooldown;
        this.color = color;
    }

    public abstract Command enemyAction(GameController controller);

    public int getMaxCooldown() { return maxCooldown; }

    public TextColor getColor() { return color; }
}
