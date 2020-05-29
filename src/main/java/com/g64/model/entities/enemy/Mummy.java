package com.g64.model.entities.enemy;

import com.g64.model.entities.Player;
import com.g64.model.entities.enemy.MovementHumour.MummyMovementAggroed;
import com.g64.model.entities.enemy.MovementHumour.MummyMovementNormal;
import com.googlecode.lanterna.TextColor;
import com.g64.model.Position;
import com.g64.model.items.drops.Drop;
import com.g64.model.items.drops.HealthConsumableDrop;

public class Mummy extends Enemy {
    public Mummy(Position position) {
        super(position, "M", new TextColor.RGB(255,255,255), true, new Drop[] {new HealthConsumableDrop()}, 10, 5);
        this.movementHumour = new MummyMovementNormal(this);
    }

    @Override
    public void checkForPlayer(Player player) {
        if (this.position.distanceTo(player.getPosition()) <= 4) {
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



    //TODO Atributo MummyMovementHumor -> Aggroed / Normal [state] no relatorio

}
