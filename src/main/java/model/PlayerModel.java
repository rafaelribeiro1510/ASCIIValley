package model;

import com.googlecode.lanterna.TextColor;

public class PlayerModel extends EntityModel {
    public PlayerModel(Position position, String string, TextColor color, boolean collision) {
        super(position, string, color, collision);
    }
}
