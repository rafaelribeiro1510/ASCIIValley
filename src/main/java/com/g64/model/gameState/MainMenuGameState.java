package com.g64.model.gameState;

import com.g64.controller.GameController;
import com.g64.controller.action.*;
import com.g64.model.menuCommands.ControlsCommand;
import com.g64.model.menuCommands.MenuOption;
import com.g64.model.menuCommands.PlayCommand;
import com.g64.model.menuCommands.QuitCommand;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.util.ArrayList;
import java.util.Arrays;

public class MainMenuGameState extends MenuGameState {
    /*
    private int selectedOption;
    private GameController gameController;
    private ArrayList<MenuOption> menuOptions;
    */

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

    public int getSelectedOption() { return selectedOption; }

    public void setSelectedOption(int selectedOption) { this.selectedOption = selectedOption; }
    */

}
