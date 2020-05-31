package com.g64.model.entities.enemy.humours;

import com.g64.controller.GameController;
import com.g64.controller.commands.*;
import com.g64.model.Position;
import com.g64.model.entities.enemy.Enemy;
import com.googlecode.lanterna.TextColor;

public abstract class AggroedHumour extends EnemyHumour {
    public AggroedHumour(Enemy me, int maxCooldown, TextColor color) {
        super(me, maxCooldown, color);
    }

    public Command defaultMovement(GameController controller){
        Position mummyPosition = me.getPosition();
        Position playerPosition = controller.getPlayer().getPosition();
        double verticalDifference = mummyPosition.verticalDifference(controller.getPlayer().getPosition());
        double horizontalDifference = mummyPosition.horizontalDifference(controller.getPlayer().getPosition());

        if      (mummyPosition.adjacent(playerPosition))    return new Controls.AttackPlayer(controller, me.getAttackValue());
        if      (verticalDifference   < 0)                  return new MoveDown(controller, me);
        else if (verticalDifference   > 0)                  return new MoveUp(controller, me);
        if      (horizontalDifference < 0)                  return new MoveRight(controller, me);
        else if (horizontalDifference > 0)                  return new MoveLeft(controller, me);
                                                            return new Null();
    }
}
