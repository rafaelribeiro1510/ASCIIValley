package model.map;


import model.entities.PlayerModel;

import java.io.*;
import java.util.ArrayList;

public class MapModel {
    private static final int CSVID = 1;
    private static final int CSVNEIGHBORS = 2;
    private static final int CSVTERRAINBEGIN = 3;
    private static final int CSVTERRAINEND = 17;

    private int width;
    private int height;

    private PlayerModel playerModel;

    private int currentChunkID;
    private ArrayList<ChunkModel> chunks;

    public MapModel(int width, int height, PlayerModel playerModel, int currentChunkID) {
        this.width = width;
        this.height = height;
        this.playerModel = playerModel;
        this.chunks = new ArrayList<ChunkModel>();
        this.currentChunkID = currentChunkID;
        this.readMap();
    }
    // TODO This right?? vv
    public PlayerModel getPlayerModel(){ return playerModel; }

    public ChunkModel getChunk() {
        for (ChunkModel chunk : this.chunks)
            if (chunk.getId() == this.currentChunkID)
                return chunk;
         return null;
    }

    public void setChunks(ArrayList<ChunkModel> chunks) {
        this.chunks = chunks;
    }

    // Reads the Map From a CSV File (whose name is at least for now hard-coded in)
    public void readMap() {
        int chunkID = 0;
        ArrayList<Integer> neighbourChunks = null;
        ArrayList<ArrayList<Integer>> terrain = new ArrayList<>();

        String line = "";

        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/Rafael/Documents/GitHub/lpoo-2020-g64/src/main/java/model/map/chunks.csv"))) {
            int rowCounter = 0;

            while ((line = br.readLine()) != null) {
                rowCounter++;

                //Should be line instead of "1", cant fix
                if (rowCounter == CSVID) chunkID = Integer.parseInt("1");

                else if (rowCounter == CSVNEIGHBORS) neighbourChunks = parseCSVLineToArray(line, ",");

                else if (rowCounter >= CSVTERRAINBEGIN && rowCounter < CSVTERRAINEND) terrain.add(parseCSVLineToArray(line, ","));

                else {
                    terrain.add(parseCSVLineToArray(line, ","));
                    rowCounter = 0;
                    this.chunks.add(new ChunkModel(width, height, terrain, chunkID, neighbourChunks));
                }
            }
        } catch (NumberFormatException | IOException | NullPointerException e){
            e.printStackTrace();
        }
    }

    //TODO put in utils
    private ArrayList<Integer> parseCSVLineToArray (String line, String splitBy) throws NumberFormatException{
        ArrayList<Integer> values = new ArrayList<>();
        String[] characters = line.split(splitBy);
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
