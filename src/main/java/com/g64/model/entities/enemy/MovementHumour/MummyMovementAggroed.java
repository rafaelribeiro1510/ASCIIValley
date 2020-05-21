package com.g64.model.entities.enemy.MovementHumour;

import com.g64.controller.GameController;
import com.g64.controller.action.*;
import com.g64.exceptions.CrossedDown;
import com.g64.exceptions.CrossedLeft;
import com.g64.exceptions.CrossedRight;
import com.g64.exceptions.CrossedUp;
import com.g64.model.entities.enemy.Enemy;

public class MummyMovementAggroed extends EnemyMovementHumour {
    public MummyMovementAggroed(Enemy me) {
        super(me);
    }

    @Override
    public void move(GameController controller) {
        double verticalDifference   = me.getPosition().verticalDifference(controller.getPlayer().getPosition());
        double horizontalDifference = me.getPosition().horizontalDifference(controller.getPlayer().getPosition());

        try {
            if      (verticalDifference   < 0) new MoveDown(controller, me).execute();
            else if (verticalDifference   > 0) new MoveUp(controller, me).execute();
            if      (horizontalDifference < 0) new MoveRight(controller, me).execute();
            else if (horizontalDifference > 0) new MoveLeft(controller, me).execute();
        }
        catch (CrossedDown | CrossedLeft | CrossedRight | CrossedUp ignored){}
    }
}
