package model;

import com.googlecode.lanterna.TextColor;

import java.util.ArrayList;

public class ChunkModel {
    private int id;
    private int width;
    private int height;
    private ArrayList<ArrayList<MapTerrainModel>> terrain;
    private ArrayList<ArrayList<MapEntityModel>> entities;
    private ArrayList<Integer> neighbours;


    public ChunkModel(int id, int width, int height, ArrayList<ArrayList<MapTerrainModel>> terrain, ArrayList<ArrayList<MapEntityModel>> entities, ArrayList<Integer> neighbours) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.terrain = terrain;
        this.entities = entities;
        this.neighbours = neighbours;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getId() { return id; }

    public TextColor getTerrainColorAt(int x, int y){
        if (new Position(x, y).insideMapBounds()) return terrain.get(y).get(x).getColor();
        else return TextColor.ANSI.BLACK;
    }

    public TextColor getTerrainColorAt(Position position){
        if (position.insideMapBounds()) return terrain.get(position.getY()).get(position.getX()).getColor();
        else return TextColor.ANSI.BLACK;
    }

    public MapEntityModel getEntityAt(int x, int y){

        if (new Position(x, y).insideMapBounds()) return entities.get(y).get(x);
        else return null;
    }

    public MapEntityModel getEntityAt(Position position){
        if (position.insideMapBounds()) return entities.get(position.getX()).get(position.getY());
        else return null;
    }
}
