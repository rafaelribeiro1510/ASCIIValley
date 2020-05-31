package com.g64.model.entities.enemy.Humours;

import com.g64.controller.GameController;
import com.g64.controller.action.*;
import com.g64.model.entities.enemy.Enemy;
import com.googlecode.lanterna.TextColor;

public class GhostAggroed extends AggroedHumour{
    private static final int maxCooldown = 15;
    private static final TextColor color = new TextColor.RGB(255,15,113);

    public GhostAggroed(Enemy me) {
        super(me, maxCooldown, color);
    }

    @Override
    public ActionEvent enemyAction(GameController controller) {
        return defaultMovement(controller);
    }
}
