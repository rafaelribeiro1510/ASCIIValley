package com.g64.model.entities.enemy.MovementHumour;

import com.g64.controller.GameController;
import com.g64.controller.action.*;
import com.g64.exceptions.*;
import com.g64.model.entities.enemy.Enemy;

import java.util.Random;

public class MummyMovementNormal extends EnemyMovementHumour {
    public MummyMovementNormal(Enemy me) {
        super(me);
    }

    @Override
    public void move(GameController controller) throws Died {
        try {
            switch (new Random().nextInt(4)) {
                case 0:
                    new MoveDown(controller, me).execute();
                case 1:
                    new MoveUp(controller, me).execute();
                case 2:
                    new MoveLeft(controller, me).execute();
                case 3:
                    new MoveRight(controller, me).execute();
            }
        }
        catch (CrossedDown | CrossedLeft | CrossedRight | CrossedUp ignored){}
    }
}
