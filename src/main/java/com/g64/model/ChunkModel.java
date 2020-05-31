package com.g64.model;

import com.g64.model.entities.EntityModel;
import com.g64.model.entities.enemy.Enemy;
import com.g64.model.entities.enemy.EnemyFactory;
import com.g64.model.entities.map.MapEntity;
import com.g64.model.entities.map.NullEntity;
import com.g64.model.terrain.MapTerrain;
import com.g64.model.terrain.NullTerrain;

import java.util.ArrayList;

public class ChunkModel {
    public static final int DEFAULT_WIDTH = 40;
    public static final int DEFAULT_HEIGHT = 15;

    private int chunkWidth;
    private int chunkHeight;
    public int getWidth() {
        return chunkWidth;
    }
    public int getHeight() {
        return chunkHeight;
    }

    private int id;
    private ArrayList<Integer> neighbours;
    private ArrayList<MapTerrain> terrain;
    private ArrayList<EntityModel> entities;

    public ChunkModel(int chunkWidth, int chunkHeight){
        this.chunkWidth = chunkWidth;
        this.chunkHeight = chunkHeight;
        this.id = 0;
        this.neighbours = null;
        this.terrain = new ArrayList<>();
        this.entities = new ArrayList<>();
    }

    public ChunkModel(int chunkWidth, int chunkHeight, int id, ArrayList<Integer> neighbours, ArrayList<MapTerrain> terrain, ArrayList<EntityModel> entities){
        this.chunkWidth = chunkWidth;
        this.chunkHeight = chunkHeight;
        this.id = id;
        this.neighbours = neighbours;
        this.terrain = terrain;
        this.entities = entities;
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

    public int getNumberEnemies() {
        int result = 0;
        for(EntityModel entity : entities) if (entity instanceof Enemy) result++;
        return result;
    }

    public void tryAddingEnemies() {
        while(getNumberEnemies() < EnemyFactory.NUMBER_ENEMIES){
            Enemy newEnemy = EnemyFactory.generate(this);
            if (getEntityAt(newEnemy.getPosition()) instanceof NullEntity) entities.add(newEnemy);
        }
    }
}
