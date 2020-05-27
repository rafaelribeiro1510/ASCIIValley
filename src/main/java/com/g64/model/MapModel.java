package com.g64.model;

import com.g64.controller.GameController;
import com.g64.controller.action.ActionEvent;
import com.g64.exceptions.Died;
import com.g64.model.entities.Player;
import com.g64.model.entities.enemy.Enemy;
import com.g64.model.entities.enemy.EnemyFactory;
import com.g64.model.entities.EntityModel;

import java.io.*;
import java.util.ArrayList;

import static com.g64.controller.GameController.MAP_HEIGHT;
import static com.g64.controller.GameController.MAP_WIDTH;

public class MapModel {
    static private final int[] ENEMY_CHUNKS = {4, 8,11};

    private int currentChunkID;
    private ArrayList<ChunkModel> chunks;

    public MapModel(int currentChunkID, String relativePathname) {
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
        if (isEnemyChunk(this.currentChunkID)) EnemyFactory.generate(this.thisChunk());
    }
    public void moveSouth(){
        if (findChunk(thisChunk().getSouthId()) != null) this.currentChunkID = thisChunk().getSouthId();
        if (isEnemyChunk(this.currentChunkID)) EnemyFactory.generate(this.thisChunk());
    }
    public void moveEast(){
        if (findChunk(thisChunk().getEastId()) != null) this.currentChunkID = thisChunk().getEastId();
        if (isEnemyChunk(this.currentChunkID)) EnemyFactory.generate(this.thisChunk());
    }
    public void moveWest(){
        if (findChunk(thisChunk().getWestId()) != null) this.currentChunkID = thisChunk().getWestId();
        if (isEnemyChunk(this.currentChunkID)) EnemyFactory.generate(this.thisChunk());
    }

    public void readMap(String relativePathname) {
        ChunkModel newChunk = new ChunkModel();
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
                    newChunk = new ChunkModel();
                }
            }
        } catch (IOException | NullPointerException e){
            e.printStackTrace();
        }
    }


    public void writeMap(String relativePathname) throws IOException {
        ChunkModel newChunk = new ChunkModel();
        String filePath = new File(relativePathname).getAbsolutePath();
        // filePath = "/Users/joaosousa/Documents/GitHub/lpoo-2020-g64/resources/chunks2.csv";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {

            for (int i = 0; i < this.chunks.size(); i++) {
                Utils.parseObjectIntoCSVLine(bw, this.chunks.get(i));
                if (i + 1 < this.chunks.size()) bw.write("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean isEnemyChunk(int id){
        for (int x : ENEMY_CHUNKS) if (x==id) return true;
        return false;
    }

    public  ArrayList<ActionEvent> updateEntities(GameController controller) {
        ArrayList<ActionEvent> result = new ArrayList<>();

        for (EntityModel entity : thisChunk().getEntities()) {
            result.add(entity.update(controller));
        }
        return result;
    }

    public void handleMapCrossing(EntityModel entity, GameController.Crossing crossing){
        if (entity instanceof Player) {
            switch (crossing) {
                case NO_CROSS:
                    break;
                case CROSS_DOWN:
                    moveSouth();
                    entity.setPosition(new Position(entity.getPosition().getX(), 0));
                    break;
                case CROSS_UP:
                    moveNorth();
                    entity.setPosition(new Position(entity.getPosition().getX(), MAP_HEIGHT - 1));
                    break;
                case CROSS_LEFT:
                    moveWest();
                    entity.setPosition(new Position(MAP_WIDTH - 1, entity.getPosition().getY()));
                    break;
                case CROSS_RIGHT:
                    moveEast();
                    entity.setPosition(new Position(0, entity.getPosition().getY()));
                    break;
            }
        }
        else if (entity instanceof Enemy){
            switch (crossing){
                case NO_CROSS: break;
                case CROSS_DOWN:
                    entity.setPosition(new Position(entity.getPosition().getX(), MAP_HEIGHT - 1));
                    break;
                case CROSS_UP:
                    entity.setPosition(new Position(entity.getPosition().getX(), 0));
                    break;
                case CROSS_LEFT:
                    entity.setPosition(new Position(0, entity.getPosition().getY()));
                    break;
                case CROSS_RIGHT:
                    entity.setPosition(new Position(MAP_WIDTH - 1, entity.getPosition().getY()));
                    break;
            }
        }
    }
}
