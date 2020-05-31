package com.g64.model.gameState;

import com.g64.controller.GameController;
import com.g64.model.menuCommands.MenuOption;

import java.util.ArrayList;

abstract public class MenuGameState implements GameState {

    protected int selectedOption;
    protected GameController gameController;
    protected ArrayList<MenuOption> menuOptions;

    abstract public void execute();

    public ArrayList<MenuOption> getMenuOptions() { return menuOptions; }

    public int getSelectedOption() { return selectedOption; }

    public void setSelectedOption(int selectedOption) { this.selectedOption = selectedOption; }
}
