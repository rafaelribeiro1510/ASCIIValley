package controller.action;

import exceptions.CrossedDown;
import controller.GameController;
import exceptions.Died;
import model.entities.Enemy;
import model.entities.EntityModel;
import model.entities.Player;
import model.entities.map.NullEntity;

public class MoveDown implements ActionEvent {
    private final GameController controller;
    private final EntityModel entity;

    public MoveDown(GameController controller, EntityModel entity) {
        this.controller = controller;
        this.entity = entity;
    }

    @Override
    public void execute() throws CrossedDown {
        EntityModel target = controller.getMapModel().thisChunk().getEntityAt(entity.getPosition().checkDown(GameController.MAP_HEIGHT));

        if (this.entity instanceof Enemy && target instanceof Player) {
            try {
                target.reduceHealth(((Enemy) this.entity).getAttackValue());
                return;
            } catch (Died died) {
                //GAME OVER
                died.printStackTrace();
            }
        }

        if (!target.hasCollision() || target.getClass() == NullEntity.class) entity.getPosition().down();
    }
}
