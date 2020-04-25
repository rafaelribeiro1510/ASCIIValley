package model.map;


import model.entities.Player;
import model.map.ChunkModel;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MapModel {
    private int width;
    private int height;

    private Player player;

    private int currentChunkID;
    private ArrayList<ChunkModel> chunks;

    public MapModel(int width, int height, Player player, int currentChunkID) {
        this.width = width;
        this.height = height;
        this.player = player;
        this.chunks = new ArrayList<ChunkModel>();
        this.currentChunkID = currentChunkID;
    }
    // This right?? vv
    public Player getPlayer(){ return player; }

    public ChunkModel getChunk() { return chunks.get(currentChunkID); }

    public void setChunks(ArrayList<ChunkModel> chunks) {
        this.chunks = chunks;
    }

    // Reads the Map From a CSV File (whose name is at least for now hard-coded in)
    public void readMap() throws FileNotFoundException {
        int rowCounter = 0;
        ArrayList<ArrayList<Integer> > values = new ArrayList<>();

        String line = "";

        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/Rafael/Documents/GitHub/lpoo-2020-g64/src/main/java/model/map/chunks.csv"))) {
            while ((line = br.readLine()) != null) {

                values.add(parseLine(line));

                rowCounter++;

                // parse Chunk
                if (rowCounter == 17) {

                    // chunk id is the first value of the first line (index 0)
                    int chunkId = values.get(0).get(0);

                    // neighbours are on the first line: indexes 1,2,3,4 (North, East, South, West)
                    ArrayList<Integer> neighbourChunks = (ArrayList<Integer>) values.get(1);

                    // terrain matrix is the rest of the array
                    ArrayList<ArrayList<Integer> > terrain = (ArrayList<ArrayList<Integer>>) values.subList(2, 16);

                    chunks.add(new ChunkModel(width, height, terrain, chunkId, neighbourChunks));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Parses a line of a CSV File
    private ArrayList<Integer> parseLine (String line) {
        String cvsSplitBy = ";";
        ArrayList<Integer> values = new ArrayList<>();

        String[] characters = line.split(cvsSplitBy);
        for (String s : characters) values.add(Integer.parseInt(s));

        return values;
    }


    /*
    Map Model (chunk)
    tem player (todas as entities)


    Bigger Character size?
    TODO:
    .csv to save the data (chunk)
    1. linha id
    2. ids dos adjacentes (N S E W)
    3. matrix com info do chao
    4. info da entity (qualquer coisa)


    matrix (cores do ecrã)
    g -> grass  -> 1
    s -> sand   -> 2
    d -> dirt   -> 3
    w -> water  -> 4
    r -> rock   -> 5

    -> criar o ficheiro .csv  - DONE
    -> read .csv function -> mapModel (info de cada mapChunk) mapChunk model / view
    -> display

    */
}
