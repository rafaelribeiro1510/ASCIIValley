package com.g64.view;

import com.g64.model.InventoryModel;
import com.g64.model.items.Item;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

public class InventoryView {
    private TextGraphics graphics;
    private int yCoordinate;
    private ItemView itemView;

    public InventoryView(Screen screen, int yCoordinate) {
        this.graphics = screen.newTextGraphics();
        this.yCoordinate = yCoordinate;
        this.itemView = new ItemView(graphics, yCoordinate);
    }

    public void draw(InventoryModel inventory, int playerHealth){
        drawItems(inventory);
        drawHealth(playerHealth);
    }

    public void drawItems(InventoryModel inventory){
        for (int i = 0 ; i < inventory.getItems().size() ; i++){
            Item item = inventory.getItems().get(i);
            if (i == inventory.getSelectedIndex()) itemView.drawSelectedItem(i, item);
            else itemView.drawNotSelectedItem(i, item);
        }
    }

    public void drawHealth(int playerHealth){
        graphics.setBackgroundColor(new TextColor.RGB(255,0,0));
        for (int j = 0 ; j < playerHealth ; j++)
            graphics.putString(j, yCoordinate + 2, " ");
    }
}
