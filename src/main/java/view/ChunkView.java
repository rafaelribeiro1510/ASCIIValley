package view;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import model.map.ChunkModel;

import java.io.IOException;
import java.util.ArrayList;

public class ChunkView {

    private TextGraphics graphics;

    public ChunkView(Screen screen) { this.graphics = screen.newTextGraphics(); }

    public void draw(ChunkModel chunk) throws IOException {
        for (int y = 0 ; y < chunk.getHeight() ; y++){
            for (int x = 0 ; x < chunk.getWidth() ; x++){
                //TODO is this ugly or nah? vv
                graphics.setBackgroundColor(chunk.getTerrainCell(x, y));
                graphics.setCharacter(x, y, ' ');
            }
        }
    }
}
