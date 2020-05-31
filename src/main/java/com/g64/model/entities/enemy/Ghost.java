package com.g64.model.entities.enemy;

import com.g64.model.Position;
import com.g64.model.entities.enemy.humours.GhostAggroed;
import com.g64.model.entities.enemy.humours.GhostNormal;
import com.g64.model.items.drops.Drop;
import com.g64.model.items.drops.HealthPackDrop;
import com.googlecode.lanterna.TextColor;

public class Ghost extends Enemy {

    public Ghost(Position position) {
        super(position, "G", new TextColor.RGB(0,178,182), true, new Drop[] {new HealthPackDrop()}, 2, 10, 4);
        aggroedHumour = new GhostAggroed(this);
        normalHumour = new GhostNormal(this);
        this.activeHumour = normalHumour;
    }

}
