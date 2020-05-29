package com.g64.model.gameState;

import com.g64.controller.action.ActionEvent;
import com.googlecode.lanterna.input.KeyStroke;

public interface GameState {

    void execute();

    ActionEvent processKey(KeyStroke key);
}
