package com.g64.model.items;

import com.g64.controller.GameController;
import com.g64.exceptions.RemoveFromInventory;
import com.g64.model.Position;

public interface Item {
    void use(GameController controller, Position position) throws RemoveFromInventory;

    String getName();

    int getValue();

    void decrementValue() throws RemoveFromInventory;

    void itemEffectsOnMap(GameController controller, Position position);

}
