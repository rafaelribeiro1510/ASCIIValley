package model.map;

import com.googlecode.lanterna.TextColor;
import model.Position;

public class MapTerrain {
    private Position position;
    private InteractionType type;

    public MapTerrain(Position position, int id) {
        this.position = position;
        this.type = InteractionType.values()[id];
    }

    public TextColor getColor() {
        switch(type){
            case Null:
                return new TextColor.RGB(0, 0, 0);
            case Grass:
                return new TextColor.RGB(0, 102, 0);
            case Sand:
                return new TextColor.RGB(204, 153, 0);
            case Soil:
                return new TextColor.RGB(102, 51, 0);
            case Water:
                return new TextColor.RGB(0, 153, 255);
            case Stone:
                return new TextColor.RGB(105, 105, 105);
            case Planks:
                return new TextColor.RGB(46,27,7);
        }
        return null;
    }

    public InteractionType getType() { return type; }

    public void setType(InteractionType type) { this.type = type; }

    public Position getPosition() { return this.position; }

}
