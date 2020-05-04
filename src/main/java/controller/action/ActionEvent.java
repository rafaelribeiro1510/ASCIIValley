package controller.action;

import exceptions.CrossedDown;
import exceptions.CrossedLeft;
import exceptions.CrossedRight;
import exceptions.CrossedUp;

import java.io.IOException;

public interface ActionEvent {
    void execute() throws IOException, CrossedDown, CrossedUp, CrossedRight, CrossedLeft;
}
