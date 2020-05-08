package model.entities;

import com.googlecode.lanterna.TextColor;
import model.Position;
import model.items.drops.Grass;
import model.items.drops.Log;
import model.items.drops.Rock;
import model.items.drops.Seed;
import model.map.InteractionType;

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
                drops.add(new Rock());
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
                drops.add(new Seed());
                break;
            case "y": // Grass
                color = new TextColor.RGB(0, 204, 0);
                collision = false;
                type = InteractionType.Plant;
                drops.add(new Seed());
                drops.add(new Grass());
                break;
            case "O": // Tree
                color = new TextColor.RGB(40,20,0);
                collision = true;
                type = InteractionType.Wood;
                drops.add(new Log());
                break;
            case "#": // Invisible wall
                color = new TextColor.RGB(0,0,0);
                collision = true;
                type = InteractionType.Null;
                break;
        }
    }

    public InteractionType getType() { return type; }

    public void remove(){
        string = " ";
        collision = false;
        type = InteractionType.Null;
    }

    public void replace(String string){
        MapEntity temp = new MapEntity(this.position, string);
        this.string = temp.string;
        this.color = temp.color;
        this.collision = temp.collision;
        this.type = temp.type;
        this.drops = temp.drops;
    }
}
