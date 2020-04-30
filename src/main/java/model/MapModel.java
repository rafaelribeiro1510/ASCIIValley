package model;


import com.googlecode.lanterna.TextColor;
import view.CSVColors;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MapModel {
    private enum CsvHeaders{
        ID,
        NEIGHBORS,
        TERRAIN_BEGIN,
        TERRAIN_END,
        ENTITIES_BEGIN,
        ENTITIES_END
    }

    private int width;
    private int height;

    private int currentChunkID;
    private ArrayList<ChunkModel> chunks;


    public MapModel(int width, int height, int currentChunkID, String relativePathname) {
        this.width = width;
        this.height = height;
        this.chunks = new ArrayList<>();
        this.currentChunkID = currentChunkID;
        this.readMap(relativePathname);
    }

    public ChunkModel getChunk() {
        for (ChunkModel chunk : this.chunks)
            if (chunk.getId() == this.currentChunkID)
                return chunk;
        System.out.print("getChunkFailed\n");
        return null;
    }

    private void addChunk(ChunkModel chunkModel){
        this.chunks.add(chunkModel);
    }

    public void readMap(String relativePathname) {
        ChunkModel newChunk = new ChunkModel(this.width, this.height);
        String line = "";
        String filePath = new File(relativePathname).getAbsolutePath();
        System.out.println("Path: " + filePath);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            int rowCounter = 0;
            while ((line = br.readLine()) != null) {
                rowCounter++;
                if (Utils.parseCSVLineIntoObject(line, rowCounter, newChunk)) {
                    this.addChunk(newChunk);
                    rowCounter = 0;
                    newChunk = new ChunkModel(this.width, this.height);
                }
            }
        } catch (IOException | NullPointerException e){
            e.printStackTrace();
        }
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
