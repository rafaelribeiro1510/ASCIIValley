package com.g64.view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

public class DeadView {

    private TextGraphics graphics;

    public DeadView(Screen screen) { graphics = screen.newTextGraphics(); }

    public void draw() {

        graphics.setBackgroundColor(TextColor.ANSI.BLACK);
        graphics.setForegroundColor(TextColor.ANSI.WHITE);

        graphics.enableModifiers(SGR.BOLD, SGR.BLINK);

        graphics.putString((40 - 9) / 2, 8, "GAME OVER");
    }
}
