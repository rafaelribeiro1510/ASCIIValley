package model.map;

import com.googlecode.lanterna.TextColor;
import javafx.geometry.Pos;
import model.Position;
import model.entities.EntityModel;
import model.entities.MapEntityModel;

import java.util.ArrayList;
import java.util.Map;

public class ChunkModel {
    private int id;
    private int width;
    private int height;
    private ArrayList<ArrayList<TextColor>> terrain;
    private ArrayList<ArrayList<MapEntityModel>> entities;
    private ArrayList<Integer> neighbours;


    public ChunkModel(int id, int width, int height, ArrayList<ArrayList<TextColor>> terrain, ArrayList<ArrayList<MapEntityModel>> entities, ArrayList<Integer> neighbours) {
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

    public TextColor getTerrainAt(int x, int y){
        return terrain.get(y).get(x);
    }

    public TextColor getTerrainAt(Position position){
        return terrain.get(position.getY()).get(position.getX());
    }

    public MapEntityModel getEntityAt(int x, int y){ return entities.get(y).get(x); }

    public MapEntityModel getEntityAt(Position position){ return entities.get(position.getX()).get(position.getY()); }
}
