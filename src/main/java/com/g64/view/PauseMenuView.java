package com.g64.view;

import com.g64.model.gameState.PauseState;
import com.g64.model.menu.menuOption;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

public class PauseMenuView {

    private TextGraphics graphics;

    public PauseMenuView(Screen screen) { graphics = screen.newTextGraphics(); }

    public void draw(PauseState pauseState) {
        int row = 6;

        graphics.setBackgroundColor(TextColor.ANSI.BLACK);
        graphics.setForegroundColor(TextColor.ANSI.WHITE);

        graphics.enableModifiers(SGR.BOLD);

        for (int i = 0; i < pauseState.getMenuOptions().size(); i++) {
            menuOption option = pauseState.getMenuOptions().get(i);

            if (i == pauseState.getSelectedOption()) {
                graphics.enableModifiers(SGR.BLINK);
                graphics.putString((40 - option.getOptionText().length()) / 2, row += 2, option.getOptionText());
                graphics.disableModifiers(SGR.BLINK);
            }
            else {
                graphics.putString((40 - option.getOptionText().length()) / 2, row += 2, option.getOptionText());
            }
        }
    }
}
