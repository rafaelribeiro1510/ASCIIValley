package model.entities;

import com.googlecode.lanterna.TextColor;
import model.Position;
import model.items.drops.Drop;
import model.items.drops.HealthConsumableDrop;

public class Mummy extends Enemy {
    public Mummy(Position position) {
        super(position, "M", new TextColor.RGB(182,0,0), true, new Drop[] {new HealthConsumableDrop()}, 10);
    }
}
