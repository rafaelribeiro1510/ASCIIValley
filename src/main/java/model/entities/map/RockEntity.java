package model.entities.map;

import com.googlecode.lanterna.TextColor;
import model.Position;
import model.items.drops.Drop;
import model.items.drops.RockDrop;

public class RockEntity extends MapEntity {
    public RockEntity(Position position) {
        super(position, "^", new TextColor.RGB(40,40,40), true, new Drop[] {new RockDrop()}, 10);
    }
}
