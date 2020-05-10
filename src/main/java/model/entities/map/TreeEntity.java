package model.entities.map;

import com.googlecode.lanterna.TextColor;
import model.Position;
import model.items.drops.Drop;
import model.items.drops.LogDrop;

public class TreeEntity extends MapEntity {
    public TreeEntity(Position position){
        super(position, "O", new TextColor.RGB(40,20,0), true, new Drop[] {new LogDrop()});
    }
}
