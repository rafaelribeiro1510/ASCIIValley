package view;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import model.map.ChunkModel;

public class ChunkView {

    private TextGraphics graphics;
    private EntityView entityView;

    public ChunkView(Screen screen) { this.graphics = screen.newTextGraphics(); entityView = new EntityView(screen);}

    public void draw(ChunkModel chunk) {
        for (int y = 0 ; y < chunk.getHeight() ; y++){
            for (int x = 0 ; x < chunk.getWidth() ; x++){
                graphics.setBackgroundColor(chunk.getTerrainAt(x, y).getColor());
                entityView.draw(chunk.getEntityAt(x,y), chunk);
            }
        }
    }
}
