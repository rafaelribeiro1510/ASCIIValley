package view;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import model.map.ChunkModel;
import model.map.MapEntity;
import model.map.MapTerrain;

public class ChunkView {

    private TextGraphics graphics;
    private EntityView entityView;

    public ChunkView(Screen screen) { this.graphics = screen.newTextGraphics(); entityView = new EntityView(screen);}

    public void draw(ChunkModel chunk) {
        for (MapEntity cell : chunk.getEntities()){
            entityView.draw(cell, chunk);
        }
    }
}
