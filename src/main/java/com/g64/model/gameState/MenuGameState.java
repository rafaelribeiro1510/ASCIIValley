package com.g64.model.gameState;

import com.g64.controller.GameController;
import com.g64.controller.action.*;
import com.g64.model.menu.controlsCommand;
import com.g64.model.menu.menuOption;
import com.g64.model.menu.playCommand;
import com.g64.model.menu.quitCommand;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.util.ArrayList;
import java.util.Arrays;

public class MenuGameState implements GameState {

    private int selectedOption;
    private GameController gameController;
    private ArrayList<menuOption> menuOptions;

    public MenuGameState(GameController gameController) {
        this.selectedOption = 0;
        this.gameController = gameController;
        menuOptions = new ArrayList<>(
                Arrays.asList(
                        new menuOption("Play",      new playCommand(gameController)),
                        new menuOption("Controls",  new controlsCommand(gameController)),
                        new menuOption("Quit",      new quitCommand(gameController))
                )
        );
    }

    @Override
    public void execute() {
        // draw menu
        gameController.getMenuView().draw(this);
    }

    @Override
    public ActionEvent processKey(KeyStroke key) {

        if (key == null)                            return new NullAction();
        if (key.getKeyType() == KeyType.ArrowUp)    return new MenuUp(this);
        if (key.getKeyType() == KeyType.ArrowDown)  return new MenuDown(this);
        if (key.getKeyType() == KeyType.Enter)      return new EnterPressed(this);

        return new NullAction();
    }

    public ArrayList<menuOption> getMenuOptions() { return menuOptions; }

    public int getSelectedOption() { return selectedOption; }

    public void setSelectedOption(int selectedOption) { this.selectedOption = selectedOption; }

}