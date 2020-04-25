package model.map;

import java.util.ArrayList;

public class ChunkModel {

    private int width;
    private int height;

    //TODO Ids or "pointers"?
    private ArrayList<ArrayList<Integer>> terrain;
    private int id;
    private ArrayList<Integer> neighbours;


    public ChunkModel(int width, int height, ArrayList<ArrayList<Integer>> terrain, int id, ArrayList<Integer> neighbours) {
        this.width = width;
        this.height = height;
        this.terrain = terrain;
        this.id = id;
        this.neighbours = neighbours;
    }

    public ArrayList<ArrayList<Integer> > getTerrain() {
        return terrain;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
