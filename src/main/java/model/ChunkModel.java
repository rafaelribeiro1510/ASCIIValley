package model;

import java.util.ArrayList;

public class ChunkModel {

    private int width;
    private int height;
    private ArrayList<ArrayList<Integer>> terrain;
    private int id;
    private ArrayList<Integer> neighbours;

    public ChunkModel(int width, int height, ArrayList<ArrayList<Integer>> terrain, int id, ArrayList<Integer> neighbours) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.terrain = terrain;
        this.neighbours = neighbours;
    }

    public ArrayList<ArrayList<Integer> > getTerrain() {
        return terrain;
    }

}
