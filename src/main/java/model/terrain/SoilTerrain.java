package model.terrain;

import com.googlecode.lanterna.TextColor;
import model.Position;

public class SoilTerrain extends MapTerrain {
    public SoilTerrain(Position position){
        super(position, new TextColor.RGB(102, 51, 0));
    }
}
