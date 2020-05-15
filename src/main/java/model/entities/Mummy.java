package model.entities;

import com.googlecode.lanterna.TextColor;
import controller.GameController;
import controller.action.*;
import model.Position;
import model.items.drops.Drop;
import model.items.drops.HealthConsumableDrop;

import java.util.Random;

public class Mummy extends Enemy {
    public Mummy(Position position) {
        super(position, "M", new TextColor.RGB(255,255,255), true, new Drop[] {new HealthConsumableDrop()}, 10);
    }

    @Override
    public void checkForPlayer(Player player) {
        aggroed = this.position.distanceTo(player.position) <= 4;
        if (aggroed) {
            this.movementCooldown = AGGROED_COOLDOWN;
            this.setColor(new TextColor.RGB(182,0,0));
        }
        else {
            this.movementCooldown = NOT_AGGROED_COOLDOWN;
            this.setColor(new TextColor.RGB(255, 255, 255));
        }
    }

    @Override
    public ActionEvent tryMoving(GameController controller) {
        if (movementCooldown == 0) {
            checkForPlayer(controller.getPlayer());
            return move(controller);
        }
        else {
            movementCooldown--;
            return null;
        }
    }

    @Override
    public ActionEvent move(GameController controller) {
        if (aggroed) {
            switch(new Random().nextInt(2)){
                case 0:
                    if (this.getPosition().leftOf(controller.getPlayer().getPosition())) return new MoveRight(controller, this);
                    else return new MoveLeft(controller, this);
                case 1:
                    if (this.getPosition().upOf(controller.getPlayer().getPosition())) return new MoveDown(controller, this);
                    else return new MoveUp(controller, this);
            }
        }
        else {
            switch (new Random().nextInt(4)){
                case 0:
                    return new MoveDown(controller, this);
                case 1:
                    return new MoveUp(controller, this);
                case 2:
                    return new MoveLeft(controller, this);
                case 3:
                    return new MoveRight(controller, this);
                default:
                    return null;
            }
        }
        return null;
    }
}
