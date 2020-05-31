package com.g64.model.entities.map;

import com.g64.model.Position;
import com.g64.model.entities.plant.GrownCarrotEntity;
import com.g64.model.entities.plant.GrownCornEntity;
import com.g64.model.entities.plant.TallGrassEntity;

public class MapEntityFactory {
    public static MapEntity get(Position position, String string){
        switch (string){
            case "^":
                return new RockEntity(position);
            case "~":
                return new WaterEntity(position);
            case "y":
                return new TallGrassEntity(position);
            case "O":
                return new TreeEntity(position);
            case "#":
                return new InvisibleWallEntity(position);
            case "i":
                return new GrownCornEntity(position);
            case "j":
                return new GrownCarrotEntity(position);
            default:
                return null;
        }
    }
}
