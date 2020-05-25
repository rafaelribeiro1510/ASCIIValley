package com.g64.view;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;

import java.awt.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Display {
    private Screen screen;

    public Display(int width, int height) {
        try {
            SwingTerminalFontConfiguration fontConfiguration = SwingTerminalFontConfiguration.newInstance(new Font(Font.MONOSPACED, Font.PLAIN, 35));
            com.googlecode.lanterna.terminal.Terminal terminal = new DefaultTerminalFactory(System.out, System.in, StandardCharsets.UTF_8).setTerminalEmulatorFontConfiguration(fontConfiguration).setInitialTerminalSize(new TerminalSize(width, height)).createTerminal();
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);   // we don't need a cursor
            screen.startScreen();             // screens must be started
            screen.doResizeIfNecessary();     // resize screen if necessary
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public Screen getScreen() {
        return screen;
    }
}
