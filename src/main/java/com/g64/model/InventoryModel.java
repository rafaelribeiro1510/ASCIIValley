package com.g64.model;

import com.g64.model.items.*;
import com.g64.model.items.drops.Drop;
import com.g64.model.items.tools.*;

import java.util.ArrayList;

public class InventoryModel {
    ArrayList<Item> items;
    int selectedIndex;

    public InventoryModel() {
        this.items = new ArrayList<>();
        items.add(new Axe());
        items.add(new Hoe());
        items.add(new Scythe());
        items.add(new Pickaxe());
        items.add(new WateringCan());
        selectedIndex = 0;
    }

    public ArrayList<Item> getItems() { return items; }

    public int getSelectedIndex() { return selectedIndex; }

    public Item getSelectedItem() {
        if (selectedIndex >= items.size()) return null;
        return items.get(selectedIndex);
    }

    public void setSelectedItem(int selectedIndex) {
        if (selectedIndex >= items.size()) return;
        this.selectedIndex = selectedIndex;
    }

    public void add(Item drop) {
        for (Item item : items) {
            if (item.getClass() == drop.getClass()) {
                ((Drop) item).incrementAmount();
                return;
            }
        }
        items.add(drop);
    }
}
