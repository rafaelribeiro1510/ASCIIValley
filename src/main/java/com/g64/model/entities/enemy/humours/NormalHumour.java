package com.g64.model.entities.enemy.humours;

import com.g64.controller.GameController;
import com.g64.controller.action.*;
import com.g64.model.entities.enemy.Enemy;
import com.googlecode.lanterna.TextColor;

import java.util.Random;

public abstract class NormalHumour extends EnemyHumour {
    public NormalHumour(Enemy me, int maxCooldown, TextColor color) {
        super(me, maxCooldown, color);
    }

    public ActionEvent defaultMovement(GameController controller){
        ActionEvent[] movements = {new MoveDown(controller, me), new MoveUp(controller, me), new MoveLeft(controller, me), new MoveRight(controller, me)};
        return movements[new Random().nextInt(movements.length)];
    }
}
