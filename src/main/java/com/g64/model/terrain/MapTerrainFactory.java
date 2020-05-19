package com.g64.model.terrain;

import com.g64.model.Position;

public class MapTerrainFactory {
    public static MapTerrain get(Position position, int id){
        switch(id){
            case 1:
                return new GrassTerrain(position);
            case 2:
                return new SandTerrain(position);
            case 3:
                return new SoilTerrain(position);
            case 4:
                return new WaterTerrain(position);
            case 5:
                return new StoneTerrain(position);
            case 6:
                return new PlanksTerrain(position);
            default:
                return null;
        }
    }
}
