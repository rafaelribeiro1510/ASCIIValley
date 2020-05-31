package com.g64.model.menu;

import com.g64.controller.GameController;

import java.io.IOException;

public class SaveMapCommand implements MenuCommand {

    GameController gameController;

    public SaveMapCommand(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void execute() {
        try {gameController.getMapModel().writeMap("resources/chunks.csv");}
        catch(IOException e) {e.printStackTrace();}

        System.out.println("Map Saved!");
    }
}
