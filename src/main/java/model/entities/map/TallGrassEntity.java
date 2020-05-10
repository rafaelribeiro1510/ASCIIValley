package model.entities.map;

import com.googlecode.lanterna.TextColor;
import model.Position;
import model.items.drops.Drop;
import model.items.drops.TallGrassDrop;
import model.items.drops.SeedDrop;

public class TallGrassEntity extends MapEntity {
    public TallGrassEntity(Position position){
        super(position, "y", new TextColor.RGB(0, 204, 0), false, new Drop[] {new SeedDrop(), new TallGrassDrop()}, 1);
    }
}
