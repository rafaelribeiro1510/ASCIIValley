package com.g64.model.entities.enemy.MovementHumour;

import com.g64.controller.GameController;
import com.g64.controller.action.ActionEvent;
import com.g64.exceptions.Died;
import com.g64.model.entities.enemy.Enemy;

public abstract class EnemyMovementHumour {
    protected Enemy me;

    public EnemyMovementHumour(Enemy me) {
        this.me = me;
    }

    public abstract void move(GameController controller) throws Died;
}
