package com.g64.model.entities.enemy.MovementHumour;

import com.g64.controller.GameController;
import com.g64.controller.action.*;
import com.g64.model.entities.enemy.Enemy;

public class MummyMovementAggroed extends EnemyMovementHumour {
    public MummyMovementAggroed(Enemy me) {
        super(me);
    }

    @Override
    public ActionEvent move(GameController controller) {
        double verticalDifference   = me.getPosition().verticalDifference(controller.getPlayer().getPosition());
        double horizontalDifference = me.getPosition().horizontalDifference(controller.getPlayer().getPosition());

        if (verticalDifference < 0) return new MoveDown(controller, me);
        else if (verticalDifference > 0) return new MoveUp(controller, me);
        if (horizontalDifference < 0) return new MoveRight(controller, me);
        else if (horizontalDifference > 0) return new MoveLeft(controller, me);

        return null;
    }
}
