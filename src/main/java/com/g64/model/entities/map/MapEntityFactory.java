package com.g64.model.entities.map;

import com.g64.model.Position;
import com.g64.model.entities.plant.TallGrassEntity;

public class MapEntityFactory {
    public static MapEntity get(Position position, String string){
        switch (string){
            case "^": // Rock
                return new RockEntity(position);
            case "~": // Water
                return new WaterEntity(position);
            case "y": // Grass
                return new TallGrassEntity(position);
            case "O": // Tree
                return new TreeEntity(position);
            case "#": // Invisible Wall
                return new InvisibleWallEntity(position);
            default:
                return null;
        }
    }
}
