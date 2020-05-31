package com.g64.model.entities.enemy;

import com.g64.controller.action.ActionEvent;
import com.g64.controller.action.NullAction;
import com.g64.model.entities.EntityModel;
import com.g64.model.entities.enemy.Humours.AggroedHumour;
import com.g64.model.entities.enemy.Humours.EnemyHumour;
import com.g64.model.entities.enemy.Humours.NormalHumour;
import com.googlecode.lanterna.TextColor;
import com.g64.controller.GameController;
import com.g64.model.Position;
import com.g64.model.items.drops.Drop;

public abstract class Enemy extends EntityModel {

    AggroedHumour aggroedHumour;
    NormalHumour normalHumour;
    EnemyHumour movementHumour;
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
    public ActionEvent update(GameController controller) {
        if (movementCooldown == 0) {
            this.movementCooldown = movementHumour.getMaxCooldown();
            return movementHumour.move(controller);
        }
        else {
            updateState(controller.getPlayer().getPosition());
            movementCooldown--;
            return new NullAction();
        }
    }

    public void setAggroedState(){
        this.setColor(aggroedHumour.getColor());
        movementHumour = aggroedHumour;
    }

    public void setNormalState(){
        this.setColor(normalHumour.getColor());
        movementHumour = normalHumour;
    }

}
