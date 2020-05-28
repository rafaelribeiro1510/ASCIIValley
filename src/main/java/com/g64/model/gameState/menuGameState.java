package com.g64.model.gameState;

import com.g64.controller.GameController;
import com.g64.model.menu.controlsCommand;
import com.g64.model.menu.menuOption;
import com.g64.model.menu.playCommand;
import com.g64.model.menu.quitCommand;

import java.util.ArrayList;
import java.util.Arrays;

public class menuGameState implements GameState {

    private ArrayList<menuOption> menuOptions = new ArrayList<menuOption>(
            Arrays.asList(
                new menuOption("Play",      new playCommand()),
                new menuOption("Controls",  new controlsCommand()),
                new menuOption("Quit",      new quitCommand())
            )
    );

    private int selectedOption;

    public menuGameState() {
        this.selectedOption = 0;
    }

    @Override
    public void execute(GameController gameController) {
        // draw menu
        gameController.getMenuView().draw(this);

        // something else?
    }

    public ArrayList<menuOption> getMenuOptions() {
        return menuOptions;
    }

    public int getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(int selectedOption) {
        this.selectedOption = selectedOption;
    }
}
