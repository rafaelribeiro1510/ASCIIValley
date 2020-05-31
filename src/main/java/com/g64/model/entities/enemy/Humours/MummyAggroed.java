package com.g64.model.entities.enemy.Humours;

import com.g64.controller.GameController;
import com.g64.controller.action.*;
import com.g64.model.entities.enemy.Enemy;
import com.googlecode.lanterna.TextColor;

public class MummyAggroed extends AggroedHumour{
    private static final int maxCooldown = 30;
    private static final TextColor color = new TextColor.RGB(182,0,0);

    public MummyAggroed(Enemy me) {
        super(me, maxCooldown, color);
    }

    @Override
    public ActionEvent enemyAction(GameController controller) {
        return defaultMovement(controller);
    }
}
