package com.g64.model.entities.enemy.humours;

import com.g64.controller.GameController;
import com.g64.controller.Commands.Command;
import com.g64.model.entities.enemy.Enemy;
import com.googlecode.lanterna.TextColor;

public class GhostAggroed extends AggroedHumour{
    private static final int maxCooldown = 15;
    private static final TextColor color = new TextColor.RGB(255,15,113);

    public GhostAggroed(Enemy me) {
        super(me, maxCooldown, color);
    }

    @Override
    public Command enemyAction(GameController controller) {
        return defaultMovement(controller);
    }
}
