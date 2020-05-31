package com.g64.model.entities.enemy.Humours;

import com.g64.model.entities.enemy.Enemy;
import com.googlecode.lanterna.TextColor;

public abstract class NormalHumour extends EnemyHumour {
    public NormalHumour(Enemy me, int maxCooldown, TextColor color) {
        super(me, maxCooldown, color);
    }
}
