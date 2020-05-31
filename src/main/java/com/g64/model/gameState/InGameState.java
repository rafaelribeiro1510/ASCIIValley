package com.g64.model.gameState;

import com.g64.controller.GameController;
import com.g64.controller.commands.*;
import com.g64.view.EntityView;
import com.g64.view.InventoryView;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

public class InGameState implements GameState {

    private GameController gameController;
    private EntityView entityView;
    private InventoryView inventoryView;

    public InGameState(GameController gameController) {
        this.gameController = gameController;
        this.entityView = new EntityView(gameController.getDisplay().getScreen());
        this.inventoryView = new InventoryView(gameController.getDisplay().getScreen());
    }

    public InGameState(GameController gameController, EntityView entityView, InventoryView inventoryView) {
        this.gameController = gameController;
        this.entityView = entityView;
        this.inventoryView = inventoryView;
    }


    @Override
    public void execute() {
        for (Command event : gameController.getMapModel().updateEntities(gameController)) gameController.processAction(event);

        // draw map
        gameController.getMapView().draw(gameController.getMapModel());

        // draw inventory
        inventoryView.draw(gameController.getInventoryModel(),
                gameController.getPlayer().getCurrentHealth(),
                gameController.getMapModel().thisChunk().getHeight()
        );

        // draw player
        entityView.draw(gameController.getPlayer(), gameController.getMapModel().thisChunk());
    }

    @Override
    public Command keyStrokeToActionEvent(KeyStroke key) {

        if (key == null)                            return new Null();

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

        if (key.getKeyType() == KeyType.Escape)     return new GoToPauseMenu(gameController);

        return new Null();
    }
}
