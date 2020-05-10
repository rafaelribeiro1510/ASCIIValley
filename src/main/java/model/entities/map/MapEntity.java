package model.entities.map;

import com.googlecode.lanterna.TextColor;
import model.Position;
import model.entities.EntityModel;
import model.items.drops.*;

public abstract class MapEntity extends EntityModel {
    public MapEntity(Position position, String string, TextColor color, boolean collision, Drop[] drops) {
        super(position, string, color, collision, drops);
    }
}
