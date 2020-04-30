package model;

import com.googlecode.lanterna.TextColor;
import view.CSVColors;

public class MapTerrainModel {
    TextColor color;

    public MapTerrainModel(int value) {
        this.color = new CSVColors(value).getRgb();
    }

    public TextColor getColor() {
        return color;
    }
}
