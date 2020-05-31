package com.g64.model.gameState;

import com.g64.controller.GameController;
import com.g64.controller.commands.Controls;
import com.g64.controller.commands.MenuOption;
import com.g64.controller.commands.Play;
import com.g64.controller.commands.Quit;
import com.g64.view.MenuView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainMenuGameState extends MenuGameState {

    MenuView menuView;

    public MainMenuGameState(GameController gameController) {
        this.selectedOption = 0;
        this.gameController = gameController;
        menuOptions = new ArrayList<>(
                Arrays.asList(
                        new MenuOption("Play",      new Play(gameController)),
                        new MenuOption("Controls",  new Controls(gameController)),
                        new MenuOption("Quit",      new Quit(gameController))
                )
        );
        this.menuView = new MenuView(gameController.getDisplay().getScreen());
    }

    public MainMenuGameState(GameController gameController, MenuView menuView) {
        this.selectedOption = 0;
        this.gameController = gameController;
        menuOptions = new ArrayList<>(
                Arrays.asList(
                        new MenuOption("Play",      new Play(gameController)),
                        new MenuOption("Controls",  new Controls(gameController)),
                        new MenuOption("Quit",      new Quit(gameController))
                )
        );
        this.menuView = menuView;
    }

    @Override
    public void execute() {
        // draw menu
        menuView.draw(this);
    }

}
