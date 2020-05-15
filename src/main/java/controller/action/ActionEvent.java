package controller.action;

import exceptions.*;

import java.io.IOException;

public interface ActionEvent {
    void execute() throws IOException, CrossedDown, CrossedUp, CrossedRight, CrossedLeft;
}
