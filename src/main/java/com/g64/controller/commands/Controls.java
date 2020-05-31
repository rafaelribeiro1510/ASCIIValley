package com.g64.controller.commands;

import com.g64.controller.GameController;
import com.g64.model.entities.EntityModel;

public class Controls implements Command {

    GameController gameController;

    public Controls(GameController gameController) { this.gameController = gameController; }

    @Override
    public void execute() {
        gameController.setGameState(gameController.getControlsState());
    }

    public static class AttackPlayer implements Command {
        private final GameController controller;
        private final int damage;

        public AttackPlayer(GameController controller, int damage) {
            this.controller = controller;
            this.damage = damage;
        }

        @Override
        public void execute() {
            if (controller.getPlayer().reduceHealth(damage) == EntityModel.healthReduction.DIED) controller.setGameState(controller.getDeadPlayerState());
        }
    }

    public static class ExitToMainMenu implements Command {
        GameController gameController;

        public ExitToMainMenu(GameController gameController) {
            this.gameController = gameController;
        }

        @Override
        public void execute() {
            gameController.getDisplay().getScreen().clear();
            gameController.setGameState(gameController.getMenuGameState());
        }
    }
}
