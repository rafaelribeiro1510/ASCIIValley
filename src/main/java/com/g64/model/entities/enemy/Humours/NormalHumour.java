package com.g64.model.entities.enemy.Humours;

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
        switch (new Random().nextInt(4)) {
            case 0:
                return new MoveDown(controller, me);
            case 1:
                return new MoveUp(controller, me);
            case 2:
                return new MoveLeft(controller, me);
            case 3:
                return new MoveRight(controller, me);
        }
        return new NullAction();
    }
}
