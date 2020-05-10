package model.entities.map;

import com.googlecode.lanterna.TextColor;
import model.Position;

public class NullEntity extends MapEntity {
    public NullEntity(Position position){
        super(position, " ", new TextColor.RGB(0,0,0), true, null);
    }
}
