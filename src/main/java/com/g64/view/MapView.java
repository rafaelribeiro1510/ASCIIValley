package com.g64.view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;
import com.g64.model.MapModel;
import com.g64.model.Position;

import java.awt.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MapView {

    private ChunkView chunkView;
    private Screen screen;

    public MapView(int width, int height)  {
        try {
            SwingTerminalFontConfiguration fontConfiguration = SwingTerminalFontConfiguration.newInstance(new Font(Font.MONOSPACED, Font.PLAIN, 35));
            Terminal terminal = new DefaultTerminalFactory(System.out, System.in, StandardCharsets.UTF_8).setTerminalEmulatorFontConfiguration(fontConfiguration).setInitialTerminalSize(new TerminalSize(width, height)).createTerminal();
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);   // we don't need a cursor
            screen.startScreen();             // screens must be started
            screen.doResizeIfNecessary();     // resize screen if necessary

            chunkView = new ChunkView(screen);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void draw(MapModel map){
        screen.clear();
        chunkView.draw(map.thisChunk());
    }

    public Screen getScreen() {
        return screen;
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
