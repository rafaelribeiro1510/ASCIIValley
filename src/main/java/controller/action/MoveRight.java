package controller.action;

import exceptions.CrossedRight;
import controller.GameController;
import exceptions.Died;
import model.entities.Enemy;
import model.entities.EntityModel;
import model.entities.Player;
import model.entities.map.NullEntity;

public class MoveRight implements ActionEvent {
    private final GameController controller;
    private final EntityModel entity;

    public MoveRight(GameController controller, EntityModel entity) {
        this.controller = controller;
        this.entity = entity;
    }

    @Override
    public void execute() throws CrossedRight {
        EntityModel target = controller.getMapModel().thisChunk().getEntityAt(entity.getPosition().checkRight(GameController.MAP_WIDTH));

        if (this.entity instanceof Enemy && target.getPosition().equals(controller.getPlayer().getPosition())) {
            try {
                controller.getPlayer().reduceHealth(((Enemy) this.entity).getAttackValue());
                return;
            } catch (Died died) {
                //GAME OVER
                died.printStackTrace();
            }
        }

        if (!target.hasCollision() || target.getClass() == NullEntity.class) entity.getPosition().right();
    }
}
