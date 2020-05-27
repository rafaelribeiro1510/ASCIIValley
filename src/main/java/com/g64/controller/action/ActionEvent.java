package com.g64.controller.action;

import com.g64.exceptions.*;
import com.g64.model.entities.EntityModel;

import java.io.IOException;

public interface ActionEvent {
    void execute() throws IOException, Died;
    EntityModel getEntity();
}
