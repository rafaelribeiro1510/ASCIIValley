package model.terrain;

import com.googlecode.lanterna.TextColor;
import model.Position;

public class PlanksTerrain extends MapTerrain{
    public PlanksTerrain(Position position){
        super(position, new TextColor.RGB(46,27,7));
    }
}
