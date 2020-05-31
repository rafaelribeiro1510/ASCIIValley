package com.g64.model.entities.enemy;

import com.g64.model.Position;
import com.g64.model.entities.enemy.humours.MummyAggroed;
import com.g64.model.entities.enemy.humours.MummyNormal;
import com.g64.model.items.drops.Drop;
import com.g64.model.items.drops.HealthConsumableDrop;
import com.googlecode.lanterna.TextColor;

public class Mummy extends Enemy {

    public Mummy(Position position) {
        super(position, "M", new TextColor.RGB(182, 172, 101), true, new Drop[] {new HealthConsumableDrop()}, 10, 5, 2);
        aggroedHumour = new MummyAggroed(this);
        normalHumour = new MummyNormal(this);
        this.activeHumour = normalHumour;
    }

    //TODO Atributo MummyMovementHumor -> Aggroed / Normal [state] no relatorio

}
