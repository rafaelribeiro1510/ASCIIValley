package com.g64.model.entities;

import com.g64.controller.GameController;
import com.g64.exceptions.Died;
import com.g64.exceptions.Grew;

public abstract class UpdatableEntity {
    public void update(GameController controller) throws Grew, Died{}
}
