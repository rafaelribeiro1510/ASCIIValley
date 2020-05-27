package com.g64.model.entities;

import com.g64.controller.GameController;
import com.g64.controller.action.ActionEvent;
import com.g64.controller.action.NullAction;

public abstract class Updatable {
    public ActionEvent update(GameController controller) { return new NullAction(); }
}
