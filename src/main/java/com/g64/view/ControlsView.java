package com.g64.view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.util.ArrayList;
import java.util.Arrays;

public class ControlsView {

    private TextGraphics graphics;
    private ArrayList<String> controls = new ArrayList<String>(
            Arrays.asList(
                    "W, A, S, D To Move The Character",
                    "Arrow Keys To Interact With The Surroundings \nUsing The Selected Item",
                    "0 To 9 To Select An Item From The Inventory",
                    "[Press Any Key To Go Back To The Main Menu]"
            )
    );

    public ControlsView(Screen screen) { graphics = screen.newTextGraphics(); }

    public void draw() {

        int row = 1;

        graphics.setBackgroundColor(TextColor.ANSI.BLACK);
        graphics.setForegroundColor(TextColor.ANSI.WHITE);

        graphics.enableModifiers(SGR.BOLD);

        graphics.putString((40 - 8)/2, row += 3, "Controls");

        graphics.disableModifiers(SGR.BOLD);

        for (String s : controls) {
            graphics.putString((40 - s.length())/2, row += 2, s);
        }
    }
}
