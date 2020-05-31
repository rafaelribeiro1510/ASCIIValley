package com.g64.model.gameState;

import com.g64.controller.GameController;
import com.g64.controller.action.*;
import com.g64.model.menu.*;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.util.ArrayList;
import java.util.Arrays;

public class PauseState implements GameState {

    private int selectedOption;
    private GameController gameController;
    private ArrayList<menuOption> pauseOptions;

    public PauseState(GameController gameController) {
        this.gameController = gameController;
        pauseOptions = new ArrayList<>(
                Arrays.asList(
                        new menuOption("Resume",    new playCommand(gameController)),
                        new menuOption("Save Map",  new SaveMapCommand(gameController)),
                        new menuOption("Quit",      new quitCommand(gameController))
                )
        );
    }

    @Override
    public void execute() {
        // draw pause menu
        gameController.getPauseMenuView().draw(this);
    }

    @Override
    public ActionEvent processKey(KeyStroke key) {

        if (key == null)                            return new NullAction();
        if (key.getKeyType() == KeyType.ArrowUp)    return new PauseMenuUp(this);
        if (key.getKeyType() == KeyType.ArrowDown)  return new PauseMenuDown(this);
        if (key.getKeyType() == KeyType.Enter)      return new PauseEnterPressed(this);

        return new NullAction();
    }

    public ArrayList<menuOption> getMenuOptions() { return pauseOptions; }

    public int getSelectedOption() { return selectedOption; }

    public void setSelectedOption(int selectedOption) { this.selectedOption = selectedOption; }
}
