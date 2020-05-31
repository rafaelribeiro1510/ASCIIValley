package com.g64.view;

import com.g64.model.MapModel;
import com.g64.model.Position;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.screen.Screen;

public class MapView {

    private ChunkView chunkView;
    private Screen screen;

    public MapView(Screen screen)  {
        this.screen = screen;
        chunkView = new ChunkView(screen);
    }

    public void draw(MapModel map){
        screen.clear();
        chunkView.draw(map.thisChunk());
    }

    public void blink(Position position) {
        screen.setCursorPosition(new TerminalPosition(position.getX(), position.getY()));
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        screen.setCursorPosition(null);
    }
}
