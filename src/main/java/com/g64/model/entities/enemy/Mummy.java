package com.g64.model.entities.enemy;

import com.g64.model.entities.enemy.Humours.MummyAggroed;
import com.g64.model.entities.enemy.Humours.MummyNormal;
import com.googlecode.lanterna.TextColor;
import com.g64.model.Position;
import com.g64.model.items.drops.Drop;
import com.g64.model.items.drops.HealthConsumableDrop;

public class Mummy extends Enemy {

    public Mummy(Position position) {
        super(position, "M", new TextColor.RGB(182, 172, 101), true, new Drop[] {new HealthConsumableDrop()}, 10, 5, 2);
        aggroedHumour = new MummyAggroed(this);
        normalHumour = new MummyNormal(this);
        this.activeHumour = normalHumour;
    }

    //TODO Atributo MummyMovementHumor -> Aggroed / Normal [state] no relatorio

}
