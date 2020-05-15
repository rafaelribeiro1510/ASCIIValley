package model.entities.map;

import com.googlecode.lanterna.TextColor;
import model.Position;
import model.items.drops.Drop;

public abstract class PlantEntity extends MapEntity {
    public PlantEntity(Position position, String string, TextColor color, boolean collision, Drop[] drops, int maxHealth) {
        super(position, string, color, collision, drops, maxHealth);
    }
}
