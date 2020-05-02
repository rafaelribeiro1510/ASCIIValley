package controller.action;

import Exceptions.CrossedEast;
import Exceptions.CrossedNorth;
import Exceptions.CrossedSouth;
import Exceptions.CrossedWest;

import java.io.IOException;

public interface ActionEvent {
    void execute() throws IOException, CrossedSouth, CrossedNorth, CrossedEast, CrossedWest;
}
