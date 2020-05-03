package model;

import com.googlecode.lanterna.TextColor;

public class MapTerrainModel {
    TextColor color;

    public MapTerrainModel(int id) {
        switch(id){
            case 0:
                color = new TextColor.RGB(0, 0, 0); // Null
                break;
            case 1:
                color = new TextColor.RGB(0, 102, 0); //Grass
                break;
            case 2:
                color = new TextColor.RGB(204, 153, 0); //Sand
                break;
            case 3:
                color = new TextColor.RGB(102, 51, 0); //Dirt
                break;
            case 4:
                color = new TextColor.RGB(0, 153, 255); //Water
                break;
            case 5:
                color = new TextColor.RGB(105, 105, 105); //Stone
                break;
            default:
                break;
        };
    }

    public TextColor getColor() {
        return color;
    }
}
