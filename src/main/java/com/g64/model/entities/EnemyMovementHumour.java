package com.g64.model.entities;

import com.g64.controller.GameController;
import com.g64.controller.action.ActionEvent;

public abstract class EnemyMovementHumour {
    protected Enemy me;

    public EnemyMovementHumour(Enemy me) {
        this.me = me;
    }

    public abstract ActionEvent move(GameController controller);
}
