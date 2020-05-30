package com.g64.model.entities.visitors;

import com.g64.model.items.Item;
import com.g64.model.items.drops.*;
import com.g64.model.items.tools.*;

public interface Visitor {
    Item.usageValue allowUsage(SeedDrop item);

    Item.usageValue allowUsage(ConsumableDrop item);

    Item.usageValue allowUsage(LogDrop item);

    Item.usageValue allowUsage(RockDrop item);

    Item.usageValue allowUsage(TallGrassDrop item);

    Item.usageValue allowUsage(Axe item);

    Item.usageValue allowUsage(Hoe item);

    Item.usageValue allowUsage(Pickaxe item);

    Item.usageValue allowUsage(Scythe item);

    Item.usageValue allowUsage(WateringCan item);
}
