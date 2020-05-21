package com.g64.model.entities;

import com.g64.controller.GameController;
import javafx.util.Pair;

public interface UpdatableEntity {
    Pair<EntityModel, EntityModel> update(GameController controller);
}
