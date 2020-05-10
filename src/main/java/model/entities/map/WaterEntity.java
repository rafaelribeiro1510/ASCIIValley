package model.entities.map;

import com.googlecode.lanterna.TextColor;
import model.Position;
import model.items.drops.Drop;

public class WaterEntity extends MapEntity{
    public WaterEntity(Position position){
        super(position, "~", new TextColor.RGB(0, 204, 255), true, null);
    }
}
