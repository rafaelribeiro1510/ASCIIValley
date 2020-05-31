package com.g64.model.gameState;

import com.g64.controller.GameController;
import com.g64.model.menuCommands.ControlsCommand;
import com.g64.model.menuCommands.MenuOption;
import com.g64.model.menuCommands.PlayCommand;
import com.g64.model.menuCommands.QuitCommand;

import java.util.ArrayList;
import java.util.Arrays;

public class MainMenuGameState extends MenuGameState {

    public MainMenuGameState(GameController gameController) {
        this.selectedOption = 0;
        this.gameController = gameController;
        menuOptions = new ArrayList<>(
                Arrays.asList(
                        new MenuOption("Play",      new PlayCommand(gameController)),
                        new MenuOption("Controls",  new ControlsCommand(gameController)),
                        new MenuOption("Quit",      new QuitCommand(gameController))
                )
        );
    }

    @Override
    public void execute() {
        // draw menu
        gameController.getMenuView().draw(this);
    }

}
