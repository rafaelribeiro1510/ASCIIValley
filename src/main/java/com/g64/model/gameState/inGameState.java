package com.g64.model.gameState;

import com.g64.controller.GameController;
import com.g64.controller.action.*;
import com.g64.exceptions.*;
import com.g64.model.Position;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;

import static com.g64.controller.GameController.MAP_HEIGHT;
import static com.g64.controller.GameController.MAP_WIDTH;

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
        gameController.getInventoryView().draw(gameController.getInventoryModel(), gameController.getPlayer().getCurrentHealth());

        // draw player
        gameController.getEntityView().draw(gameController.getPlayer(), gameController.getMapModel().thisChunk());

        try {
            if (actionEvent != null) actionEvent.execute();
            gameController.getMapModel().updateEntities(gameController);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (CrossedUp crossedUp) {
            gameController.getMapModel().moveNorth();
            gameController.getPlayer().setPosition(new Position(gameController.getPlayer().getPosition().getX(), MAP_HEIGHT - 1));
        }
        catch (CrossedLeft crossedLeft) {
            gameController.getMapModel().moveWest();
            gameController.getPlayer().setPosition(new Position(MAP_WIDTH - 1, gameController.getPlayer().getPosition().getY()));
        }
        catch (CrossedDown crossedDown) {
            gameController.getMapModel().moveSouth();
            gameController.getPlayer().setPosition(new Position(gameController.getPlayer().getPosition().getX(), 0));
        }
        catch (CrossedRight crossedRight) {
            gameController.getMapModel().moveEast();
            gameController.getPlayer().setPosition(new Position(0, gameController.getPlayer().getPosition().getY()));
        } catch (Died died) {
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

        return null;
    }
}
