package model.map;

import com.googlecode.lanterna.TextColor;
import javafx.geometry.Pos;
import model.Position;
import model.entities.EntityModel;

import java.util.ArrayList;

public class ChunkModel {

    private int width;
    private int height;

    private ArrayList<ArrayList<TextColor>> terrain;
    private ArrayList<ArrayList<EntityModel>> entities;
    private int id;
    private ArrayList<Integer> neighbours;


    public ChunkModel(int width, int height, ArrayList<ArrayList<TextColor>> terrain, int id, ArrayList<Integer> neighbours) {
        this.width = width;
        this.height = height;
        this.terrain = terrain;
        this.id = id;
        this.neighbours = neighbours;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getId() { return id; }

    public TextColor getTerrainCell(int x, int y){
        return terrain.get(y).get(x);
    }
    public TextColor getTerrainCell(Position position){
        return terrain.get(position.getY()).get(position.getX());
    }
}
