package data.entities;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import data.Position;

public abstract class Entity {
    private Position position;
    private char character;
    private TextColor.ANSI backgroundColor;
    private TextColor.ANSI foregroundColor;

    public Entity() {
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
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
