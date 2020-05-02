package model;

import java.io.*;
import java.util.ArrayList;

public class MapModel {
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

    public ChunkModel findChunk(int id){
        for (ChunkModel chunk : this.chunks)
            if (chunk.getId() == id)
                return chunk;
        return null;
    }

    public ChunkModel thisChunk() {
        return findChunk(currentChunkID);
    }

    public void addChunk(ChunkModel chunkModel){
        this.chunks.add(chunkModel);
    }

    public void moveNorth(){
        if (findChunk(thisChunk().getNorthId()) != null) this.currentChunkID = thisChunk().getNorthId();
    }
    public void moveSouth(){
        if (findChunk(thisChunk().getSouthId()) != null) this.currentChunkID = thisChunk().getSouthId();
    }
    public void moveEast(){
        if (findChunk(thisChunk().getEastId()) != null) this.currentChunkID = thisChunk().getEastId();
    }
    public void moveWest(){
        if (findChunk(thisChunk().getWestId()) != null) this.currentChunkID = thisChunk().getWestId();
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
}
