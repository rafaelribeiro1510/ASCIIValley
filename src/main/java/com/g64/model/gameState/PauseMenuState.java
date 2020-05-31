package com.g64.model.gameState;

import com.g64.controller.GameController;
import com.g64.controller.action.*;
import com.g64.model.menuCommands.*;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.util.ArrayList;
import java.util.Arrays;

public class PauseMenuState extends MenuGameState {

    /*
    private int selectedOption;
    private GameController gameController;
    private ArrayList<MenuOption> pauseOptions;
    */

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
    /*
    @Override
    public ActionEvent processKey(KeyStroke key) {

        if (key == null)                            return new NullAction();
        if (key.getKeyType() == KeyType.ArrowUp)    return new MenuUp(this);
        if (key.getKeyType() == KeyType.ArrowDown)  return new MenuDown(this);
        if (key.getKeyType() == KeyType.Enter)      return new EnterPressed(this);

        return new NullAction();
    }
    */
    /*
    public ArrayList<MenuOption> getMenuOptions() { return menuOptions; }
    */
    /*
    public int getSelectedOption() { return selectedOption; }
    */
    /*
    public void setSelectedOption(int selectedOption) { this.selectedOption = selectedOption; }
    */
}
