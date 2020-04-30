package model;

import com.googlecode.lanterna.TextColor;
import model.EntityModel;
import model.Position;

public class MapEntityModel extends EntityModel {

    public MapEntityModel(Position position, String string) {
        super(position, string, TextColor.ANSI.BLACK, false);

        switch (string){
            case "^": //Stone
                this.color = new TextColor.RGB(40,40,40);
                this.collision = true;
                ;
                break;
            case "~": //Water
                this.color = new TextColor.RGB(0, 204, 255);
                this.collision = true;
                break;
            case ":": //Dirt
                this.color = new TextColor.RGB(26, 12, 0);
                this.collision = false;
                break;
            case "y": //Grass patch
                this.color = new TextColor.RGB(0, 204, 0);
                this.collision = false;
            default:
                break;
        }
    }
}
