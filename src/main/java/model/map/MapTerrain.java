package model.map;

import com.googlecode.lanterna.TextColor;

public class MapTerrain {
    private InteractionType type;

    public MapTerrain(int id) {
        type = InteractionType.values()[id];
    }

    public TextColor getColor() {
        switch(type){
            case Null:
                return new TextColor.RGB(0, 0, 0); // Null
            case Grass:
                return new TextColor.RGB(0, 102, 0); // Grass
            case Sand:
                return new TextColor.RGB(204, 153, 0); // Sand
            case Soil:
                return new TextColor.RGB(102, 51, 0); // Soil
            case Water:
                return new TextColor.RGB(0, 153, 255); // Water
            case Stone:
                return new TextColor.RGB(105, 105, 105); // Stone
        }
        return null;
    }

    public InteractionType getType() { return type; }

    public void setType(InteractionType type) { this.type = type; }

}
