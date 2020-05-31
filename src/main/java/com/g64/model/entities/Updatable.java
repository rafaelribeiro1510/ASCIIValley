package com.g64.model.entities;

import com.g64.controller.GameController;
import com.g64.controller.commands.Command;
import com.g64.controller.commands.Null;

public abstract class Updatable {
    public Command update(GameController controller) { return new Null(); }
}
