package com.g64.model.entities.visitors;

import com.g64.exceptions.RemoveFromInventory;
import com.g64.model.items.drops.*;
import com.g64.model.items.tools.*;

public interface Visitor {
    void allowUsage(SeedDrop item) throws RemoveFromInventory;

    void allowUsage(ConsumableDrop item) throws RemoveFromInventory;

    void allowUsage(LogDrop item) throws RemoveFromInventory;

    void allowUsage(RockDrop item) throws RemoveFromInventory;

    void allowUsage(TallGrassDrop item) throws RemoveFromInventory;

    void allowUsage(Axe item) throws RemoveFromInventory;

    void allowUsage(Hoe item) throws RemoveFromInventory;

    void allowUsage(Pickaxe item) throws RemoveFromInventory;

    void allowUsage(Scythe item) throws RemoveFromInventory;

    void allowUsage(WateringCan item) throws RemoveFromInventory;
}
