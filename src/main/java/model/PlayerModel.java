package model;

import com.googlecode.lanterna.TextColor;
import controller.GameController;
import view.MapView;

public class PlayerModel extends MovableEntityModel {
    public PlayerModel(Position position, String string, TextColor color) {
        super(position, string, color);
    }
}
