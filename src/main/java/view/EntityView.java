package view;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import model.entities.EntityModel;

import java.io.IOException;

public class EntityView {
    private TextGraphics graphics;

    public EntityView(Screen screen) { this.graphics = screen.newTextGraphics(); }

    public void draw(EntityModel entity, TextColor backgroundColor) throws IOException {
        //TODO is this ugly or nah? vv
        graphics.setForegroundColor(entity.getForegroundColor());
        graphics.setBackgroundColor(backgroundColor);
        graphics.setCharacter(entity.getPosition().getX(), entity.getPosition().getY(), entity.getTextCharacter().getCharacter());
    }
}
