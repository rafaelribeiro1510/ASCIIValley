package view;

import com.googlecode.lanterna.TextColor;

public class CSVColors {
    public TextColor rgb;

    public CSVColors(Integer id) {
        switch (id){
            case 0: //NULL
                rgb = new TextColor.RGB(0, 0, 0);
                break;
            case 1: //Grass
                rgb = new TextColor.RGB(0, 102, 0);
                break;
            case 2: //Sand
                rgb = new TextColor.RGB(204, 153, 0);
                break;
            case 3: //Dirt
                rgb = new TextColor.RGB(102, 51, 0);
                break;
            case 4: //Water
                rgb = new TextColor.RGB(0, 153, 255);
                break;
            case 5: //Stone
                rgb = new TextColor.RGB(105, 105, 105);
                break;
        }
    }

    public TextColor getRgb() {
        return rgb;
    }
}
