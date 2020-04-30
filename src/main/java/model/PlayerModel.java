package model;

import com.googlecode.lanterna.TextColor;
import controller.GameController;
import view.MapView;

public class PlayerModel extends MovableEntityModel {
    public PlayerModel(Position position, String string, TextColor color) {
        super(position, string, color);
    }

    public void updatePosition(GameController.COMMAND command, MapModel mapModel) {
        if (command == GameController.COMMAND.UP && canMove(GameController.COMMAND.UP, mapModel)) this.getPosition().up();

        if (command == GameController.COMMAND.DOWN && canMove(GameController.COMMAND.DOWN, mapModel)) this.getPosition().down();

        if (command == GameController.COMMAND.LEFT && canMove(GameController.COMMAND.LEFT, mapModel)) this.getPosition().left();

        if (command == GameController.COMMAND.RIGHT && canMove(GameController.COMMAND.RIGHT, mapModel)) this.getPosition().right();
    }
}
