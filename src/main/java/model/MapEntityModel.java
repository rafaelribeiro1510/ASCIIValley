package model;

import com.googlecode.lanterna.TextColor;

import java.util.HashMap;
import java.util.Map;



class myPair {
    public TextColor myColor;
    public boolean myCollision;

    public myPair(TextColor myColor, boolean myCollision) {
        this.myColor = myColor;
        this.myCollision = myCollision;
    }
}

public class MapEntityModel extends EntityModel {

    Map<String, myPair> map2 = new HashMap<String, myPair>() {{
        put("^", new myPair(new TextColor.RGB(40,40,40),     true)); // Stone
        put("~", new myPair(new TextColor.RGB(0, 204, 255),  true)); // Water
        put(":", new myPair(new TextColor.RGB(26, 12, 0),   false)); // Dirt
        put("y", new myPair(new TextColor.RGB(0, 204, 0),   false)); // Grass patch
    }};

    public MapEntityModel(Position position, String string) {
        super(position, string, TextColor.ANSI.BLACK, false);

        if (map2.containsKey(string)) {
            this.color = map2.get(string).myColor;
            this.collision = map2.get(string).myCollision;
        }
    }

}
