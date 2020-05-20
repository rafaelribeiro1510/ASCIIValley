package com.g64.model.entities;

import com.googlecode.lanterna.TextColor;
import com.g64.controller.GameController;
import com.g64.controller.action.*;
import com.g64.model.Position;
import com.g64.model.items.drops.Drop;
import com.g64.model.items.drops.HealthConsumableDrop;

import java.util.Random;

public class Mummy extends Enemy {
    public Mummy(Position position) {
        super(position, "M", new TextColor.RGB(255,255,255), true, new Drop[] {new HealthConsumableDrop()}, 10, 5);
        this.movementHumour = new MummyMovementNormal(this);
    }

    @Override
    public void checkForPlayer(Player player) {
        if (this.position.distanceTo(player.position) <= 4) {
            this.movementCooldown = AGGROED_COOLDOWN;
            this.setColor(new TextColor.RGB(182,0,0));
            movementHumour = new MummyMovementAggroed(this);
        }
        else {
            this.movementCooldown = NOT_AGGROED_COOLDOWN;
            this.setColor(new TextColor.RGB(255, 255, 255));
            movementHumour = new MummyMovementNormal(this);
        }
    }

    @Override
    public ActionEvent tryMoving(GameController controller) {
        if (movementCooldown == 0) {
            checkForPlayer(controller.getPlayer());
            return movementHumour.move(controller);
        }
        else {

            movementCooldown--;
            return null;
        }
    }

    //TODO Atributo MummyMovementHumor -> Aggroed / Normal [state] no relatorio

}
