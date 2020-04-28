package model.entities;

import com.googlecode.lanterna.TextColor;
import model.Position;

public class MapEntityModel extends EntityModel {

    public MapEntityModel(Position position, String string) {
        super(position, string, TextColor.ANSI.BLACK);

        switch (string){
            case "^": //Stone
                this.color = new TextColor.RGB(40,40,40)
                ;
                break;
            case "~": //Water
                this.color = new TextColor.RGB(0, 204, 255);
                break;
            case ":": //Dirt
                this.color = new TextColor.RGB(26, 12, 0);
                break;
            case "y": //Grass patch
                this.color = new TextColor.RGB(0, 204, 0);
            default:
                break;
        }
    }
}
