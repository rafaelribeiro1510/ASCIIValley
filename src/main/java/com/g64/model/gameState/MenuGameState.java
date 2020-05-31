package com.g64.model.gameState;

import com.g64.controller.GameController;
import com.g64.controller.commands.*;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.util.ArrayList;

abstract public class MenuGameState implements GameState {

    protected int selectedOption;
    protected GameController gameController;
    protected ArrayList<MenuOption> menuOptions;

    abstract public void execute();

    public Command keyStrokeToActionEvent(KeyStroke key) {

        if (key == null)                            return new Null();
        if (key.getKeyType() == KeyType.ArrowUp)    return new MenuUp(this);
        if (key.getKeyType() == KeyType.ArrowDown)  return new MenuDown(this);
        if (key.getKeyType() == KeyType.Enter)      return new EnterPressed(this);

        return new Null();
    }

    public ArrayList<MenuOption> getMenuOptions() { return menuOptions; }

    public int getSelectedOption() { return selectedOption; }

    public void setSelectedOption(int selectedOption) { this.selectedOption = selectedOption; }
}
