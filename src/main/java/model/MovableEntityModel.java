package model;

import com.googlecode.lanterna.TextColor;
import controller.GameController;

public class MovableEntityModel extends EntityModel {

    GameController gameController;

    public MovableEntityModel(Position position, String string, TextColor color) {
        super(position, string, color, true);

    }

    boolean canMove(GameController.COMMAND command, MapModel mapModel){
        MapEntityModel target = null;
        switch (command){
            case UP:
                target = mapModel.thisChunk().getEntityAt(this.position.getX(), this.position.getY() - 1);
                break;
            case DOWN:
                target = mapModel.thisChunk().getEntityAt(this.position.getX(), this.position.getY() + 1);
                break;
            case LEFT:
                target = mapModel.thisChunk().getEntityAt(this.position.getX() - 1, this.position.getY());
                break;
            case RIGHT:
                target = mapModel.thisChunk().getEntityAt(this.position.getX() + 1, this.position.getY());
                break;
            default:
                break;
        }
        return target == null || !target.hasCollision();
    }
}
