package com.g64.model.gameState;

import com.g64.controller.GameController;
import com.g64.controller.action.ActionEvent;
import com.googlecode.lanterna.input.KeyStroke;

public interface GameState {

    void execute(GameController gameController);

    ActionEvent processKey(KeyStroke key);
}
