package model.terrain;

import com.googlecode.lanterna.TextColor;
import model.Position;

public class SandTerrain extends MapTerrain {
    public SandTerrain(Position position){
        super(position, new TextColor.RGB(204, 153, 0));
    }
}
