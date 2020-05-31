package com.g64.model.entities;

import com.g64.model.MapModel;
import com.g64.model.Position;
import com.googlecode.lanterna.TextColor;

public class Player extends EntityModel {
    public Player(Position position, String string, TextColor color) {
        super(position, string, color, true, null, 40);
    }

    @Override
    public void handleBoundaryCrossing(MapModel map){
        MapModel.Crossing crossing = map.checkBoundaries(position);
        switch (crossing) {
            case NO_CROSS:
                break;
            case CROSS_DOWN:
                map.moveSouth();
                setPosition(new Position(position.getX(), 0));
                break;
            case CROSS_UP:
                map.moveNorth();
                setPosition(new Position(position.getX(), map.thisChunk().getHeight() - 1));
                break;
            case CROSS_LEFT:
                map.moveWest();
                setPosition(new Position(map.thisChunk().getWidth() - 1, position.getY()));
                break;
            case CROSS_RIGHT:
                map.moveEast();
                setPosition(new Position(0, position.getY()));
                break;
        }
    }
}
