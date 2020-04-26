package view.map;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import model.map.ChunkModel;

import java.io.IOException;
import java.util.ArrayList;

public class ChunkView {

    private TextGraphics graphics;

    public ChunkView(Screen screen) {
        this.graphics = screen.newTextGraphics();
    }

    //Drawing each pixel , may not be needed
    public void drawChunk(Screen screen, ChunkModel chunk) throws IOException {
        ArrayList<ArrayList<Integer>> terrain = chunk.getTerrain();
        for (int y = 0 ; y < chunk.getHeight() ; y++){
            for (int x = 0 ; x < chunk.getWidth() ; x++){
                //TODO is this ugly or nah? vv
                graphics.setBackgroundColor(new CSVColors(terrain.get(y).get(x)).getRgb());
                graphics.setCharacter(x, y, ' ');
                screen.refresh();
            }
        }
    }
}
