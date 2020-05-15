package model;

import model.entities.EntityModel;
import model.entities.map.MapEntity;
import model.entities.map.NullEntity;
import model.terrain.MapTerrain;
import model.terrain.NullTerrain;

import java.util.ArrayList;

public class ChunkModel {
    private int id;
    private ArrayList<MapTerrain> terrain;
    private ArrayList<EntityModel> entities;
    private ArrayList<Integer> neighbours;

    public ChunkModel(){
        this.id = 0;
        this.terrain = new ArrayList<>();
        this.entities = new ArrayList<>();
        this.neighbours = null;
    }

    public void setId(int id) { this.id = id; }

    public int getId() { return id; }

    public ArrayList<EntityModel> getEntities() { return entities; }

    public MapTerrain getTerrainAt(Position position){
        for (MapTerrain value : terrain) if (value.getPosition().equals(position)) return value;
        return new NullTerrain(position);
    }

    public EntityModel getEntityAt(Position position){
        for (EntityModel value : entities) if (value.getPosition().equals(position)) return value;
        return new NullEntity(position);
    }

    public int getNorthId(){ return neighbours.get(0); }
    public int getSouthId(){ return neighbours.get(1); }
    public int getEastId(){ return neighbours.get(2); }
    public int getWestId(){ return neighbours.get(3); }

    public void setNeighbours(ArrayList<Integer> neighbours) { this.neighbours = neighbours; }

    public void addTerrainLine(ArrayList<MapTerrain> line){ this.terrain.addAll(line); }

    public void addEntityLine(ArrayList<MapEntity> line){ this.entities.addAll(line); }

    public ArrayList<MapTerrain> getTerrain() { return terrain; }
}
