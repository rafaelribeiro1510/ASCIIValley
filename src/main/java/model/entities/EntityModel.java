package model.entities;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import model.Position;

public abstract class EntityModel {
    protected Position position;
    protected TextCharacter textCharacter;

    public EntityModel(Position position, char character, TextColor foregroundColor) {
            this.position = position;
        this.textCharacter = new TextCharacter(character, foregroundColor, TextColor.ANSI.BLACK);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public TextCharacter getTextCharacter() {
        return textCharacter;
    }

    //TODO smelly smell??
    public TextColor getForegroundColor() { return textCharacter.getForegroundColor(); }

}
