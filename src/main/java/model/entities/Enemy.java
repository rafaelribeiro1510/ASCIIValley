package model.entities;

import com.googlecode.lanterna.TextColor;
import model.Position;
import model.items.drops.Drop;

public abstract class Enemy extends EntityModel {
    public Enemy(Position position, String string, TextColor color, boolean collision, Drop[] drops, int maxHealth) {
        super(position, string, color, collision, drops, maxHealth);
    }
}
