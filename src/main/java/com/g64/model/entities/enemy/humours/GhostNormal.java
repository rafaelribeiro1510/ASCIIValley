package com.g64.model.entities.enemy.humours;

import com.g64.controller.GameController;
import com.g64.controller.commands.Command;
import com.g64.model.entities.enemy.Enemy;
import com.googlecode.lanterna.TextColor;

public class GhostNormal extends NormalHumour{
    private static final int maxCooldown = 50;
    private static final TextColor color = new TextColor.RGB(0, 178, 182);

    public GhostNormal(Enemy me) {
        super(me, maxCooldown, color);
    }

    @Override
    public Command enemyAction(GameController controller) {
        return defaultMovement(controller);
    }
}
