package com.g64.model.entities.enemy;

import com.g64.controller.GameController;
import com.g64.controller.Commands.Command;
import com.g64.controller.Commands.NullAction;
import com.g64.model.MapModel;
import com.g64.model.Position;
import com.g64.model.entities.EntityModel;
import com.g64.model.entities.enemy.humours.AggroedHumour;
import com.g64.model.entities.enemy.humours.EnemyHumour;
import com.g64.model.entities.enemy.humours.NormalHumour;
import com.g64.model.items.drops.Drop;
import com.googlecode.lanterna.TextColor;

public abstract class Enemy extends EntityModel {

    AggroedHumour aggroedHumour;
    NormalHumour normalHumour;
    EnemyHumour activeHumour;
    int movementCooldown;
    int attackValue;
    int visionDistance;

    public Enemy(Position position, String string, TextColor color, boolean collision, Drop[] drops, int maxHealth, int attackValue, int visionDistance) {
        super(position, string, color, collision, drops, maxHealth);
        this.movementCooldown = 0;
        this.attackValue = attackValue;
        this.visionDistance = visionDistance;
    }

    public void updateState(Position playerPosition) {
        if (this.position.distanceTo(playerPosition) <= visionDistance) setAggroedState();
        else setNormalState();
    }

    public int getAttackValue() {
        return attackValue;
    }

    @Override
    public Command update(GameController controller) {
        if (movementCooldown == 0) {
            this.movementCooldown = activeHumour.getMaxCooldown();
            return activeHumour.enemyAction(controller);
        }
        else {
            updateState(controller.getPlayer().getPosition());
            movementCooldown--;
            return new NullAction();
        }
    }

    public void setAggroedState(){
        this.setColor(aggroedHumour.getColor());
        activeHumour = aggroedHumour;
    }

    public void setNormalState(){
        this.setColor(normalHumour.getColor());
        activeHumour = normalHumour;
    }

    @Override
    public void handleBoundaryCrossing(MapModel map){
        MapModel.Crossing crossing = map.checkBoundaries(position);
        switch (crossing){
            case NO_CROSS: break;
            case CROSS_DOWN:
                setPosition(new Position(position.getX(), map.thisChunk().getHeight() - 1));
                break;
            case CROSS_UP:
                setPosition(new Position(position.getX(), 0));
                break;
            case CROSS_LEFT:
                setPosition(new Position(0, position.getY()));
                break;
            case CROSS_RIGHT:
                setPosition(new Position(map.thisChunk().getWidth() - 1, position.getY()));
                break;
        }
    }

}
