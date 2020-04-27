package view;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import model.map.ChunkModel;

import java.io.IOException;

public class ChunkView {

    private TextGraphics graphics;
    private EntityView entityView;

    public ChunkView(Screen screen) { this.graphics = screen.newTextGraphics(); entityView = new EntityView(screen);}

    public void draw(ChunkModel chunk) throws IOException {
        for (int y = 0 ; y < chunk.getHeight() ; y++){
            for (int x = 0 ; x < chunk.getWidth() ; x++){
                //TODO is this ugly or nah? vv
                graphics.setBackgroundColor(chunk.getTerrainAt(x, y));
                entityView.draw(chunk.getEntityAt(x,y), chunk.getTerrainAt(x,y));
            }
        }
    }
}
