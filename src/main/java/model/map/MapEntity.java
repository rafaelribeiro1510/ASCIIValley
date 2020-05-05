package model.map;

import com.googlecode.lanterna.TextColor;
import model.EntityModel;
import model.Position;

public class MapEntity extends EntityModel {
    private InteractionType type;

    public MapEntity(Position position, String string) {
        super(position, string, TextColor.ANSI.BLACK, false);

        switch (string){
            case " ": // Null
                color = new TextColor.RGB(0,0,0);
                collision = false;
                type = InteractionType.Null;
                break;
            case "^": // Rock
                color = new TextColor.RGB(40,40,40);
                collision = true;
                type = InteractionType.Rock;
                break;
            case "~": // Water
                color = new TextColor.RGB(0, 204, 255);
                collision = true;
                type = InteractionType.Water;
                break;
            case ":": // Seed
                color = new TextColor.RGB(26, 12, 0);
                collision = false;
                type = InteractionType.Plant;
                break;
            case "y": // Grass
                color = new TextColor.RGB(0, 204, 0);
                collision = false;
                type = InteractionType.Plant;
                break;
        }
    }

    public InteractionType getType() { return type; }

    public void remove(){
        string = " ";
        collision = false;
    }
}
