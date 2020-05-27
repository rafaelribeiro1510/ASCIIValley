package com.g64.model.entities.visitors;

import com.g64.controller.GameController;
import com.g64.model.MapModel;
import com.g64.model.entities.Player;
import com.g64.model.entities.enemy.Enemy;

public class MovementVisitor {
    MapModel map;
    GameController.Crossing crossing;

    public MovementVisitor(MapModel map, GameController.Crossing crossing) {
        this.map = map;
        this.crossing = crossing;
    }

    public void allowMovement(Player entity){

    }

    public void allowMovement(Enemy entity){

    }
}
