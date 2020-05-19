package com.g64.view;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.g64.controller.GameController;
import com.g64.model.InventoryModel;
import com.g64.model.items.Item;

public class InventoryView {
    private TextGraphics graphics;

    public InventoryView(Screen screen) { graphics = screen.newTextGraphics(); }

    public void draw(InventoryModel inventory, int playerHealth){
        for (int i = 0 ; i < inventory.getItems().size() ; i++){
            Item item = inventory.getItems().get(i);
            if (i == inventory.getSelectedIndex()) {
                graphics.setBackgroundColor(TextColor.ANSI.WHITE);
                graphics.setForegroundColor(TextColor.ANSI.BLACK);
            }
            else {
                graphics.setBackgroundColor(TextColor.ANSI.BLACK);
                graphics.setForegroundColor(TextColor.ANSI.WHITE);
            }
            graphics.putString(i * 5, GameController.MAP_HEIGHT, item.getName());
            graphics.putString(i * 5, GameController.MAP_HEIGHT + 1, String.valueOf(item.getValue()));
        }
        graphics.setBackgroundColor(new TextColor.RGB(255,0,0));
        for (int j = 0 ; j < playerHealth ; j++) graphics.putString(j, GameController.MAP_HEIGHT + 2, " ");
    }
}
