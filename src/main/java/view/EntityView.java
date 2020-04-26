package view;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import model.entities.EntityModel;

import java.io.IOException;

public class EntityView {
    private TextGraphics graphics;

    public EntityView(Screen screen) { this.graphics = screen.newTextGraphics(); }

    public void draw(Screen screen, EntityModel entity) throws IOException {
        //TODO is this ugly or nah? vv
        graphics.setForegroundColor(entity.getForegroundColor());
        graphics.setCharacter(entity.getPosition().getX(), entity.getPosition().getY(), entity.getCharacter());
    }
}
