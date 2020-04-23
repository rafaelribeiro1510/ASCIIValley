package model.entities;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import model.Position;

public abstract class Entity {
    protected Position position;
    protected TextCharacter character;
    protected TextColor.ANSI backgroundColor;
    protected TextColor.ANSI foregroundColor;

    public Entity(Position position, TextCharacter character, TextColor.ANSI backgroundColor, TextColor.ANSI foregroundColor) {
        this.position = position;
        this.character = character;
        this.backgroundColor = backgroundColor;
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

    public void setCharacter(TextCharacter character) {
        this.character = character;
    }

    public TextColor.ANSI getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(TextColor.ANSI backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public TextColor.ANSI getForegroundColor() {
        return foregroundColor;
    }

    public void setForegroundColor(TextColor.ANSI foregroundColor) {
        this.foregroundColor = foregroundColor;
    }
}
