package com.g64.model.items.drops;

import com.g64.exceptions.RemoveFromInventory;
import com.g64.model.entities.target.Target;

public class GrownCornDrop extends ConsumableDrop {
    public GrownCornDrop() {
        super("CORN", 5);
    }

    @Override
    public void accept(Target target) throws RemoveFromInventory {
        target.allowUsage(this);
    }
}
