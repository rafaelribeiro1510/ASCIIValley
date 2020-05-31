package com.g64.model.gameState;

import com.g64.controller.commands.Command;
import com.googlecode.lanterna.input.KeyStroke;

public interface GameState {

    void execute();

    Command keyStrokeToActionEvent(KeyStroke key);
}
