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

    public MapView(Screen screen, ChunkView chunkView) {
        this.screen = screen;
        this.chunkView = chunkView;
    }

    public void draw(MapModel map){
        screen.clear();
        chunkView.draw(map.thisChunk());
    }

}
