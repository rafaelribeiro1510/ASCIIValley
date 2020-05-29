package com.g64.controller.action;

import com.g64.exceptions.*;

public interface ActionEvent {
    void execute() throws Died;
}
