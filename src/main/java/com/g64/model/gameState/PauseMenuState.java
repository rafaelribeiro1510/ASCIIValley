package com.g64.model.gameState;

import com.g64.controller.GameController;
import com.g64.model.menuCommands.MenuOption;
import com.g64.model.menuCommands.PlayCommand;
import com.g64.model.menuCommands.QuitCommand;
import com.g64.model.menuCommands.SaveMapCommand;

import java.util.ArrayList;
import java.util.Arrays;

public class PauseMenuState extends MenuGameState {

    public PauseMenuState(GameController gameController) {
        this.selectedOption = 0;
        this.gameController = gameController;
        menuOptions = new ArrayList<>(
                Arrays.asList(
                        new MenuOption("Resume",    new PlayCommand(gameController)),
                        new MenuOption("Save Map",  new SaveMapCommand(gameController)),
                        new MenuOption("Quit",      new QuitCommand(gameController))
                )
        );
    }

    @Override
    public void execute() {
        // draw pause menu
        gameController.getPauseMenuView().draw(this);
    }

}
