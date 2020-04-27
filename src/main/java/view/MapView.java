package view;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;
import model.map.MapModel;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;

public class MapView {

    public enum COMMAND {UP, RIGHT, DOWN, LEFT, QUIT}

    //TODO ChunkController aqui?? Ou comunica logo com o ChunkView?
    private ChunkView chunkView;
    private EntityView entityView;
    private Screen screen;

    public MapView(int width, int height) throws IOException {
        //TODO need help with resizing
        SwingTerminalFontConfiguration fontConfiguration = SwingTerminalFontConfiguration.newInstance(new Font(Font.MONOSPACED, Font.PLAIN, 40));
        Terminal terminal = new DefaultTerminalFactory().setTerminalEmulatorFontConfiguration(fontConfiguration).setInitialTerminalSize(new TerminalSize(width, height)).createTerminal();
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);   // we don't need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();     // resize screen if necessary

        chunkView = new ChunkView(screen);
        entityView = new EntityView(screen);
    }

    public void drawMap(MapModel map){
        try{
            screen.clear();
            //Draw map here
            chunkView.draw(map.getChunk());
            //Draw entities here
            entityView.draw(map.getPlayerModel(), map.getChunk().getTerrainAt(map.getPlayerModel().getPosition()));
            //TODO entity must receive terrain to preserve background color (Should entityView receive chunk attribute? or should entityView be called in chunkView?)
            screen.refresh();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    //TODO Must be here because it gets input from screen??
    public COMMAND getCommand() throws IOException {
        while (true) {
            KeyStroke key = screen.readInput();
            if (key.getKeyType() == KeyType.ArrowUp) return COMMAND.UP;
            if (key.getKeyType() == KeyType.ArrowRight) return COMMAND.RIGHT;
            if (key.getKeyType() == KeyType.ArrowDown) return COMMAND.DOWN;
            if (key.getKeyType() == KeyType.ArrowLeft) return COMMAND.LEFT;

            if (key.getKeyType() == KeyType.Escape) {
                screen.close();
                return COMMAND.QUIT;
            }
        }
    }
}
