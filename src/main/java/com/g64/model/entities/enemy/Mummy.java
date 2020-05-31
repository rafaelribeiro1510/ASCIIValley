package com.g64.model.entities.enemy;

import com.g64.model.entities.enemy.Humours.MummyAggroed;
import com.g64.model.entities.enemy.Humours.MummyNormal;
import com.googlecode.lanterna.TextColor;
import com.g64.model.Position;
import com.g64.model.items.drops.Drop;
import com.g64.model.items.drops.HealthConsumableDrop;

public class Mummy extends Enemy {
    protected static final int AGGROED_COOLDOWN = 30;
    protected static final int NOT_AGGROED_COOLDOWN = 45;

    public Mummy(Position position) {
        super(position, "M", new TextColor.RGB(255,255,255), true, new Drop[] {new HealthConsumableDrop()}, 10, 5, 4);
        aggroedHumour = new MummyAggroed(this, AGGROED_COOLDOWN, new TextColor.RGB(182,0,0));
        normalHumour = new MummyNormal(this, NOT_AGGROED_COOLDOWN, new TextColor.RGB(255, 255, 255));
        this.movementHumour = normalHumour;
    }

    //TODO Atributo MummyMovementHumor -> Aggroed / Normal [state] no relatorio

}
