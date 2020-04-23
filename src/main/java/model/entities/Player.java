package model.entities;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import model.Position;
import view.MapView;

public class Player extends Entity{

    public Player(Position position, TextCharacter character, TextColor.ANSI backgroundColor, TextColor.ANSI foregroundColor) {
        super(position, character, backgroundColor, foregroundColor);
    }

    public void updatePosition(MapView.COMMAND command) {
        if (command == MapView.COMMAND.UP) this.setPosition(this.getPosition().up());

        if (command == MapView.COMMAND.DOWN) this.setPosition(this.getPosition().down());

        if (command == MapView.COMMAND.LEFT) this.setPosition(this.getPosition().left());

        if (command == MapView.COMMAND.RIGHT) this.setPosition(this.getPosition().right());
    }
}
