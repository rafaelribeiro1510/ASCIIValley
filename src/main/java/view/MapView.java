package view;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;
import model.MapModel;

import java.awt.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MapView {

    //TODO ChunkController aqui?? Ou comunica logo com o ChunkView?
    private ChunkView chunkView;
    private Screen screen;

    public MapView(int width, int height)  {
        try {
            SwingTerminalFontConfiguration fontConfiguration = SwingTerminalFontConfiguration.newInstance(new Font(Font.MONOSPACED, Font.PLAIN, 40));
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

    public void drawMap(MapModel map){
        screen.clear();
        //Draw map here
        chunkView.draw(map.thisChunk());
        //TODO entity must receive terrain to preserve background color (Should entityView receive chunk attribute? or should entityView be called in chunkView?)
    }

    public Screen getScreen() {
        return screen;
    }
}
