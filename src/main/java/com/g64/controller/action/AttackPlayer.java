package com.g64.controller.action;

import com.g64.controller.GameController;
import com.g64.model.entities.EntityModel;
import com.g64.model.gameState.DeadPlayerState;

public class AttackPlayer implements ActionEvent {
    private final GameController controller;
    private final int damage;

    public AttackPlayer(GameController controller, int damage) {
        this.controller = controller;
        this.damage = damage;
    }

    @Override
    public void execute() {
        // if (controller.getPlayer().reduceHealth(damage) == EntityModel.healthReduction.DIED) controller.setGameState(new DeadPlayerState(controller));
        if (controller.getPlayer().reduceHealth(damage) == EntityModel.healthReduction.DIED) controller.setGameState(controller.getDeadPlayerState());
    }
}
