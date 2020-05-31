package com.g64.view;

import com.g64.model.InventoryModel;
import com.g64.model.items.Item;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

public class InventoryView {
    private TextGraphics graphics;
    private int yCoordinate;

    public InventoryView(Screen screen, int yCoordinate) {
        this.graphics = screen.newTextGraphics();
        this.yCoordinate = yCoordinate;
    }

    public void draw(InventoryModel inventory, int playerHealth){
        drawItems(inventory);
        drawHealth(playerHealth);
    }
    
    public void drawItems(InventoryModel inventory){
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
            graphics.putString(i * 5, yCoordinate, item.getName());
            graphics.putString(i * 5, yCoordinate + 1, String.valueOf(item.getValue()));
        }
    }

    public void drawHealth(int playerHealth){
        graphics.setBackgroundColor(new TextColor.RGB(255,0,0));
        for (int j = 0 ; j < playerHealth ; j++) graphics.putString(j, yCoordinate + 2, " ");
    }
}
