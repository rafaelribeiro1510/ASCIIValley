package model.entities;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import model.Position;

public abstract class EntityModel {
    protected Position position;
    protected TextCharacter character;
    protected TextColor foregroundColor;

    public EntityModel(Position position, TextCharacter character, TextColor foregroundColor) {
        this.position = position;
        this.character = character;
        this.foregroundColor = foregroundColor;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public TextCharacter getCharacter() {
        return character;
    }

    public TextColor getForegroundColor() { return foregroundColor; }

}
