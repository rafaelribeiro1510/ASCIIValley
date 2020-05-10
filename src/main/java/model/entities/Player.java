package model.entities;

import com.googlecode.lanterna.TextColor;
import model.Position;

public class Player extends EntityModel {
    public Player(Position position, String string, TextColor color) {
        super(position, string, color, true, null, 40);
    }
}
