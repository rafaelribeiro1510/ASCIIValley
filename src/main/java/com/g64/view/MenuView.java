package com.g64.view;

import com.g64.model.gameState.MainMenuGameState;
import com.g64.model.menuCommands.MenuOption;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

public class MenuView {

    private TextGraphics graphics;

    public MenuView(Screen screen) { graphics = screen.newTextGraphics(); }

    public void draw(MainMenuGameState mainMenuGameState) {
        int row = 4;
        graphics.setBackgroundColor(TextColor.ANSI.BLACK);
        graphics.setForegroundColor(TextColor.ANSI.WHITE);

        graphics.enableModifiers(SGR.BOLD);

        graphics.putString(14, row, "ASCII Valley");

        row += 3;

        for (int i = 0; i < mainMenuGameState.getMenuOptions().size(); i++) {
            MenuOption option = mainMenuGameState.getMenuOptions().get(i);

            if (i == mainMenuGameState.getSelectedOption()) {
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
