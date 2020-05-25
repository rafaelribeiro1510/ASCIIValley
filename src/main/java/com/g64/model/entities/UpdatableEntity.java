package com.g64.model.entities;

import com.g64.controller.GameController;
import com.g64.exceptions.Grew;

public interface UpdatableEntity {
    void update(GameController controller) throws Grew;
}
