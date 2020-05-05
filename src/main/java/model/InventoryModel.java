package model;

import model.items.*;

import java.util.ArrayList;

public class InventoryModel {
    private static final int INVENTORY_SLOTS = 10;

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
}
