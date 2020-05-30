package com.g64.model.entities.visitors;

import com.g64.exceptions.RemoveFromInventory;
import com.g64.model.items.Item;
import com.g64.model.items.drops.*;
import com.g64.model.items.tools.*;

public interface Visitor {
    Item.itemValue allowUsage(SeedDrop item);

    Item.itemValue allowUsage(ConsumableDrop item);

    Item.itemValue allowUsage(LogDrop item);

    Item.itemValue allowUsage(RockDrop item);

    Item.itemValue allowUsage(TallGrassDrop item);

    Item.itemValue allowUsage(Axe item);

    Item.itemValue allowUsage(Hoe item);

    Item.itemValue allowUsage(Pickaxe item);

    Item.itemValue allowUsage(Scythe item);

    Item.itemValue allowUsage(WateringCan item);
}
