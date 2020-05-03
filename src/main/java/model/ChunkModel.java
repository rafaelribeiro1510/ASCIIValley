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

    public ChunkModel(int width, int height){
        this.id = 0;
        this.width = width;
        this.height = height;
        this.terrain = new ArrayList<>();
        this.entities = new ArrayList<>();
        this.neighbours = null;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setId(int id) { this.id = id; }

    public int getId() { return id; }

    public TextColor getTerrainColorAt(int x, int y){
        return terrain.get(y).get(x).getColor();
    }

    public TextColor getTerrainColorAt(Position position){
        return terrain.get(position.getY()).get(position.getX()).getColor();
    }

    public MapEntityModel getEntityAt(int x, int y){
        return entities.get(y).get(x);
    }

    public MapEntityModel getEntityAt(Position position){
        return entities.get(position.getY()).get(position.getX());
    }

    public int getNorthId(){ return neighbours.get(0); }
    public int getSouthId(){ return neighbours.get(1); }
    public int getEastId(){ return neighbours.get(2); }
    public int getWestId(){ return neighbours.get(3); }

    public void setNeighbours(ArrayList<Integer> neighbours) {
        this.neighbours = neighbours;
    }

    public void addTerrainLine(ArrayList<MapTerrainModel> line){
        this.terrain.add(line);
    }

    public void addEntityLine(ArrayList<MapEntityModel> line){
        this.entities.add(line);
    }
}
