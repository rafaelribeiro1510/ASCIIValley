package com.g64.view;

import com.g64.model.items.Item;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class ItemView {
    private TextGraphics graphics;
    private int yCoordinate;

    public ItemView(TextGraphics graphics, int yCoordinate) {
        this.graphics = graphics;
        this.yCoordinate = yCoordinate;
    }

    public void drawSelectedItem(int index, Item item){
        graphics.setBackgroundColor(TextColor.ANSI.WHITE);
        graphics.setForegroundColor(TextColor.ANSI.BLACK);
        graphics.putString(index * 5, yCoordinate, item.getName());
        graphics.putString(index * 5, yCoordinate + 1, String.valueOf(item.getValue()));
    }

    public void drawNotSelectedItem(int index, Item item){
        graphics.setBackgroundColor(TextColor.ANSI.BLACK);
        graphics.setForegroundColor(TextColor.ANSI.WHITE);
        graphics.putString(index * 5, yCoordinate, item.getName());
        graphics.putString(index * 5, yCoordinate + 1, String.valueOf(item.getValue()));
    }
}
