package com.g64.model.entities.enemy.Humours;

import com.g64.model.entities.enemy.Enemy;
import com.googlecode.lanterna.TextColor;

public abstract class AggroedHumour extends EnemyHumour {
    public AggroedHumour(Enemy me, int maxCooldown, TextColor color) {
        super(me, maxCooldown, color);
    }
}
