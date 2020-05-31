package com.g64.model.entities.enemy.humours;

import com.g64.controller.GameController;
import com.g64.controller.Commands.Command;
import com.g64.model.entities.enemy.Enemy;
import com.googlecode.lanterna.TextColor;

public class MummyNormal extends NormalHumour{
    private static final int maxCooldown = 45;
    private static final TextColor color = new TextColor.RGB(182, 172, 101);

    public MummyNormal(Enemy me) {
        super(me, maxCooldown, color);
    }

    @Override
    public Command enemyAction(GameController controller) {
        return defaultMovement(controller);
    }
}
