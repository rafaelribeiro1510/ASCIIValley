package com.g64.controller.action;

import com.g64.controller.GameController;
import com.g64.exceptions.Died;

public class AttackPlayer implements ActionEvent {
    private final GameController controller;
    private final int damage;

    public AttackPlayer(GameController controller, int damage) {
        this.controller = controller;
        this.damage = damage;
    }

    @Override
    public void execute() throws Died {
        controller.getPlayer().reduceHealth(damage);
    }
}
