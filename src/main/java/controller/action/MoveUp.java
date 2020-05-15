package controller.action;

import exceptions.CrossedUp;
import controller.GameController;
import exceptions.Died;
import model.entities.Enemy;
import model.entities.EntityModel;
import model.entities.Player;
import model.entities.map.NullEntity;

public class MoveUp implements ActionEvent {
    private final GameController controller;
    private final EntityModel entity;

    public MoveUp(GameController controller, EntityModel entity) {
        this.controller = controller;
        this.entity = entity;
    }

    @Override
    public void execute() throws CrossedUp {
        EntityModel target = controller.getMapModel().thisChunk().getEntityAt(entity.getPosition().checkUp(GameController.MAP_HEIGHT));

        if (this.entity instanceof Enemy && target.getPosition().equals(controller.getPlayer().getPosition())) {
            try {
                controller.getPlayer().reduceHealth(((Enemy) this.entity).getAttackValue());
                return;
            } catch (Died died) {
                //GAME OVER
                died.printStackTrace();
            }
        }

        if (!target.hasCollision() || target.getClass() == NullEntity.class) entity.getPosition().up();
    }
}
