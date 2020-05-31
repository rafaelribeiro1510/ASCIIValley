package com.g64.model.terrain;

import com.g64.model.Position;

public class MapTerrainFactory {
    public static MapTerrain get(Position position, int id){
        switch(id){
            case 1:
                return new GrassTerrain(position, id);
            case 2:
                return new SandTerrain(position, id);
            case 3:
                return new SoilTerrain(position, id);
            case 4:
                return new WaterTerrain(position, id);
            case 5:
                return new StoneTerrain(position, id);
            case 6:
                return new PlanksTerrain(position, id);
            default:
                return null;
        }
    }
}
