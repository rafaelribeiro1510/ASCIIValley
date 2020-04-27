package model.entities;

import com.googlecode.lanterna.TextColor;
import model.Position;

public class MapEntityModel extends EntityModel {

    public MapEntityModel(Position position, String string) {
        super(position, string, TextColor.ANSI.BLACK);
        switch (string){
            case "\u00F6": //Stone
                this.color = new TextColor.RGB(153, 102, 51);
                break;
            case "\u0060": //Sand
                this.color = new TextColor.RGB(253, 253, 121);
                break;
            case "\u2248": //Water
                this.color = new TextColor.RGB(0, 204, 255);
                break;
            case "\u2591": //Dirt
                this.color = new TextColor.RGB(255, 153, 0);
                break;
            default:
                break;
        }
    }
}
