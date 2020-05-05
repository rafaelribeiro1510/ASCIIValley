package view;

import com.googlecode.lanterna.screen.Screen;
import model.map.ChunkModel;
import model.map.MapEntity;

public class ChunkView {

    private EntityView entityView;

    public ChunkView(Screen screen) { entityView = new EntityView(screen);}

    public void draw(ChunkModel chunk) {
        for (MapEntity cell : chunk.getEntities()){
            entityView.draw(cell, chunk);
        }
    }
}
