package com.g64.controller.action;

import com.g64.exceptions.*;

import java.io.IOException;

public interface ActionEvent {
    void execute() throws IOException, CrossedDown, CrossedUp, CrossedRight, CrossedLeft, Died;
}
