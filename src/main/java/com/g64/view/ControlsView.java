package com.g64.view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

public class ControlsView {

    private TextGraphics graphics;

    public ControlsView(Screen screen) { graphics = screen.newTextGraphics(); }

    public void draw() {

        int row = 3;

        graphics.setBackgroundColor(TextColor.ANSI.BLACK);
        graphics.setForegroundColor(TextColor.ANSI.WHITE);

        graphics.enableModifiers(SGR.BOLD);

        graphics.putString((40 - 8)/2, row, "Controls");

        graphics.disableModifiers(SGR.BOLD);

        graphics.putString(4, row += 3, "W, A, S, D To Move The Character");
        graphics.putString(4, row += 2, "Arrow Keys To Interact With");
        graphics.putString(6, row += 1, "The Surroundings Using");
        graphics.putString(6, row += 1, "The Selected Item");
        graphics.putString(4, row += 2, "0 To 9 To Select An Item");
        graphics.putString(6, row += 1, "From The Inventory");
        graphics.putString(4, row += 2, "[Press Any Key To Go Back");
        graphics.putString(6, row += 1, "To The Main Menu]");
    }
}
