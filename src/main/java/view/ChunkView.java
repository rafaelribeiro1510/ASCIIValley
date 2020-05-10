package view;

import com.googlecode.lanterna.screen.Screen;
import model.ChunkModel;
import model.terrain.MapTerrain;

public class ChunkView {

    private EntityView entityView;

    public ChunkView(Screen screen) { entityView = new EntityView(screen);}

    public void draw(ChunkModel chunk) {
        for (MapTerrain cell : chunk.getTerrain()){
            entityView.draw(chunk.getEntityAt(cell.getPosition()), chunk);
        }
    }
}
