package view;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import model.EntityModel;

import java.io.IOException;

public class EntityView {
    private TextGraphics graphics;

    public EntityView(Screen screen) { this.graphics = screen.newTextGraphics(); }

    public void draw(EntityModel entity, TextColor backgroundColor) {
        graphics.setForegroundColor(entity.getColor());
        graphics.setBackgroundColor(backgroundColor);
        graphics.putString(entity.getPosition().getX(), entity.getPosition().getY(), entity.getString());
    }
}
