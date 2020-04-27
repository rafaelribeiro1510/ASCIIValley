package model.entities;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import model.Position;
import view.MapView;

public class PlayerModel extends EntityModel {
    private Position position;
    public PlayerModel(Position position,  String string, TextColor color) {
        super(position, string, color);
    }

    public void updatePosition(MapView.COMMAND command) {
        if (command == MapView.COMMAND.UP) this.setPosition(this.getPosition().up());

        if (command == MapView.COMMAND.DOWN) this.setPosition(this.getPosition().down());

        if (command == MapView.COMMAND.LEFT) this.setPosition(this.getPosition().left());

        if (command == MapView.COMMAND.RIGHT) this.setPosition(this.getPosition().right());
    }
}
