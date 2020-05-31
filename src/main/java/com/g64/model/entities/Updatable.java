package com.g64.model.entities;

import com.g64.controller.GameController;
import com.g64.controller.Commands.Command;
import com.g64.controller.Commands.NullAction;

public abstract class Updatable {
    public Command update(GameController controller) { return new NullAction(); }
}
