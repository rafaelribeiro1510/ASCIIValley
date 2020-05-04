package model;

import model.items.*;

import java.util.ArrayList;

public class InventoryModel {
    private static final int INVENTORY_SLOTS = 10;

    ArrayList<Item> items;
    int selectedItem;

    public InventoryModel() {
        this.items = new ArrayList<>();
        items.add(new Axe());
        items.add(new Hoe());
        items.add(new Scythe());
        items.add(new Pickaxe());
        items.add(new WateringCan());
        selectedItem = 0;
    }

    public Item getSelectedItem() {
        if (selectedItem >= items.size()) return null;
        return items.get(selectedItem);
    }

    public void setSelectedItem(int selectedItem) {
        if (selectedItem >= items.size()) return;
        this.selectedItem = selectedItem;
    }
}
