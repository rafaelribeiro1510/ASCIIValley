package view;

import com.googlecode.lanterna.TextColor;

import java.util.HashMap;
import java.util.Map;

public class CSVColors {

    Map<Integer, TextColor.RGB> map = new HashMap<Integer, TextColor.RGB>() {{
        put(0, new TextColor.RGB(0, 0, 0)); // Null
        put(1, new TextColor.RGB(0, 102, 0)); //Grass
        put(2, new TextColor.RGB(204, 153, 0)); //Sand
        put(3, new TextColor.RGB(102, 51, 0)); //Dirt
        put(4, new TextColor.RGB(0, 153, 255)); //Water
        put(5, new TextColor.RGB(105, 105, 105)); //Stone
    }};

    private TextColor rgb;

    public CSVColors(Integer id) {
        rgb = map.get(id);
    }

    public TextColor getRgb() {
        return rgb;
    }
}
