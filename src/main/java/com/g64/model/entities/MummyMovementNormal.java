package com.g64.model.entities;

import com.g64.controller.GameController;
import com.g64.controller.action.*;

import java.util.Random;

public class MummyMovementNormal extends EnemyMovementHumour {
    public MummyMovementNormal(Enemy me) {
        super(me);
    }

    @Override
    public ActionEvent move(GameController controller) {
        switch (new Random().nextInt(4)){
            case 0:
                return new MoveDown(controller, me);
            case 1:
                return new MoveUp(controller, me);
            case 2:
                return new MoveLeft(controller, me);
            case 3:
                return new MoveRight(controller, me);
            default:
                return null;
        }
    }
}
