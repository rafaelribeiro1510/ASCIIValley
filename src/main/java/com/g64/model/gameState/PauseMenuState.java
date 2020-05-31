package com.g64.model.gameState;

import com.g64.controller.GameController;
import com.g64.controller.Commands.MenuOption;
import com.g64.controller.Commands.PlayCommand;
import com.g64.controller.Commands.QuitCommand;
import com.g64.controller.Commands.SaveMapCommand;
import com.g64.view.PauseMenuView;

import java.util.ArrayList;
import java.util.Arrays;

public class PauseMenuState extends MenuGameState {

    PauseMenuView pauseMenuView;

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
        this.pauseMenuView = new PauseMenuView(gameController.getDisplay().getScreen());
    }

    public PauseMenuState(GameController gameController, PauseMenuView pauseMenuView) {
        this.selectedOption = 0;
        this.gameController = gameController;
        menuOptions = new ArrayList<>(
                Arrays.asList(
                        new MenuOption("Resume",    new PlayCommand(gameController)),
                        new MenuOption("Save Map",  new SaveMapCommand(gameController)),
                        new MenuOption("Quit",      new QuitCommand(gameController))
                )
        );
        this.pauseMenuView = pauseMenuView;
    }

    @Override
    public void execute() {
        // draw pause menu
        pauseMenuView.draw(this);
    }

}
