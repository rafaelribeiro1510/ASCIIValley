package model.entities.map;

import com.googlecode.lanterna.TextColor;
import model.Position;
import model.items.drops.Drop;
import model.items.drops.SeedDrop;

public class SeedEntity extends PlantEntity {
    public SeedEntity(Position position){
        super(position, ":", new TextColor.RGB(26, 12, 0), false, new Drop[] {new SeedDrop()}, 1);
    }
}
