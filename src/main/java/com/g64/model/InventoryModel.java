package com.g64.model;

import com.g64.model.entities.visitors.ItemVisitor;
import com.g64.model.items.Item;
import com.g64.model.items.drops.Drop;
import com.g64.model.items.tools.*;

import java.util.ArrayList;

public class InventoryModel {
    ArrayList<Item> items;
    int selectedIndex;

    public InventoryModel() {
        this.items = new ArrayList<>();
        items.add(new Axe(100));
        items.add(new Hoe(100));
        items.add(new Scythe(100));
        items.add(new Pickaxe(100));
        items.add(new WateringCan(100));
        selectedIndex = 0;
    }

    public InventoryModel(ArrayList<Item> items){
        this.items = items;
        this.selectedIndex = 0;
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

    public void useItem(Item item, ItemVisitor itemVisitor){
        if (item == null) return;
        if (item.accept(itemVisitor) == Item.usageValue.BROKEN) items.remove(item);
    }
}
