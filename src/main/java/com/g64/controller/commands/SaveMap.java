package com.g64.controller.commands;

import com.g64.controller.GameController;

import java.io.IOException;

public class SaveMap implements Command {

    GameController gameController;

    public SaveMap(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void execute() {
        try {gameController.getMapModel().writeMap("resources/chunks.csv");}
        catch(IOException e) {e.printStackTrace();}

        System.out.println("Map Saved!");
    }
}
