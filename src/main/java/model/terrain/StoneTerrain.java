package model.terrain;

import com.googlecode.lanterna.TextColor;
import model.Position;

public class StoneTerrain extends MapTerrain {
    public StoneTerrain(Position position){
        super(position, new TextColor.RGB(105, 105, 105));
    }
}
