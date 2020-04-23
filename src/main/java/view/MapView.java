package view;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import model.MapModel;

import java.io.IOException;

public class MapView {
    public enum COMMAND {UP, RIGHT, DOWN, LEFT}

    private Screen screen;

    public MapView(int width, int height) throws IOException {
        Terminal terminal = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(width, height)).createTerminal();
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);   // we don't need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();     // resize screen if necessary
    }

    public void drawMap(MapModel map){
        try{
            screen.clear();
            //Draw map here
            //Draw entities here
            screen.setCharacter(map.getPlayer().getPosition().getX(), map.getPlayer().getPosition().getY(), map.getPlayer().getCharacter());
            screen.refresh();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    // Must be here because it gets input from screen??
    public COMMAND getCommand() throws IOException {
        while (true) {
            KeyStroke key = screen.readInput();
            if (key.getKeyType() == KeyType.ArrowUp) return COMMAND.UP;
            if (key.getKeyType() == KeyType.ArrowRight) return COMMAND.RIGHT;
            if (key.getKeyType() == KeyType.ArrowDown) return COMMAND.DOWN;
            if (key.getKeyType() == KeyType.ArrowLeft) return COMMAND.LEFT;
        }
    }
}
