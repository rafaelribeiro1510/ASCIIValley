package com.g64.view;

import com.g64.model.MenuModel;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

public class MenuView {

    private TextGraphics graphics;

    public MenuView(Screen screen) { graphics = screen.newTextGraphics(); }

    public void draw(MenuModel menuModel) {
        int row = 4;
        graphics.setBackgroundColor(TextColor.ANSI.BLACK);
        graphics.setForegroundColor(TextColor.ANSI.WHITE);

        graphics.enableModifiers(SGR.BOLD);

        graphics.putString(14, row, "ASCII Valley");

        row += 3;

        for (int i = 0; i < menuModel.getMenuItems().size(); i++) {
            if (i == menuModel.getSelectedOption()) {
                graphics.enableModifiers(SGR.BLINK);
                graphics.putString((40 - menuModel.getMenuItems().get(i).length()) / 2, row += 2, menuModel.getMenuItems().get(i));
                graphics.disableModifiers(SGR.BLINK);
            }
            else {
                graphics.putString((40 - menuModel.getMenuItems().get(i).length()) / 2, row += 2, menuModel.getMenuItems().get(i));
            }
        }
    }
}
