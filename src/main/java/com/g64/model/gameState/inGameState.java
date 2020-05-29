package com.g64.model.gameState;

import com.g64.controller.GameController;
import com.g64.controller.action.*;
import com.g64.exceptions.*;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;

public class inGameState implements GameState {

    private GameController gameController;

    public inGameState(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void execute(GameController gameController, ActionEvent actionEvent) {
        // draw map
        gameController.getMapView().draw(gameController.getMapModel());

        // draw inventory
        gameController.getInventoryView().draw(gameController.getInventoryModel(),
                gameController.getPlayer().getCurrentHealth(),
                gameController.getMapModel().thisChunk().getHeight()
        );

        // draw player
        gameController.getEntityView().draw(gameController.getPlayer(), gameController.getMapModel().thisChunk());

        try {
            if (actionEvent != null) actionEvent.execute();
            for (ActionEvent event : gameController.getMapModel().updateEntities(gameController)) {
                event.execute();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (Died died) {
            gameController.setGameState(new deadPlayerState(gameController));
        }
    }

    @Override
    public ActionEvent processKey(KeyStroke key) {

        if (key == null)                            return null;
        if (key.getKeyType() == KeyType.ArrowUp)    return new InteractUp(gameController);
        if (key.getKeyType() == KeyType.ArrowDown)  return new InteractDown(gameController);
        if (key.getKeyType() == KeyType.ArrowLeft)  return new InteractLeft(gameController);
        if (key.getKeyType() == KeyType.ArrowRight) return new InteractRight(gameController);

        if (key.getKeyType() == KeyType.Character) {
            if (key.getCharacter() >= '0' && key.getCharacter() <= '9') return new SelectSlot(gameController, (Character.getNumericValue(key.getCharacter()) - 1) % 10);
            if (key.getCharacter() == 'w')          return new MoveUp(gameController, gameController.getPlayer());
            if (key.getCharacter() == 'd')          return new MoveRight(gameController, gameController.getPlayer());
            if (key.getCharacter() == 's')          return new MoveDown(gameController, gameController.getPlayer());
            if (key.getCharacter() == 'a')          return new MoveLeft(gameController, gameController.getPlayer());
        }

        if (key.getKeyType() == KeyType.Escape)     return new ExitToMainMenu(gameController);

        return null;
    }
}
