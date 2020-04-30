package model;


import com.googlecode.lanterna.TextColor;
import view.CSVColors;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MapModel {
    //usar enum, camel case mais descritivo
    private static final int CSVID = 1;
    private static final int CSVNEIGHBORS = 2;
    private static final int CSVTERRAINBEGIN = 3;
    private static final int CSVTERRAINEND = 17;
    private static final int CSVENTITIESBEGIN = 18;
    private static final int CSVENTITIESEND = 32;

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

    // Reads the Map From a CSV File (whose name is at least for now hard-coded in)
    //TODO simplificar
    public void readMap(String relativePathname) {
        int id = 0;
        ArrayList<Integer> neighbors = null;
        ArrayList<ArrayList<MapTerrainModel>> terrain = new ArrayList<>();
        ArrayList<ArrayList<MapEntityModel>> entities = new ArrayList<>();

        String line = "";

        String filePath = new File(relativePathname).getAbsolutePath();
        System.out.println("Path: " + filePath);
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            int rowCounter = 0;

            while ((line = br.readLine()) != null) {
                rowCounter++;

                if (rowCounter == CSVID) id = Integer.parseInt(line);

                else if (rowCounter == CSVNEIGHBORS) neighbors = parseCSVLineToIntegers(line, ",");

                else if (rowCounter >= CSVTERRAINBEGIN && rowCounter <= CSVTERRAINEND) terrain.add(parseArrayToTerrain(parseCSVLineToIntegers(line, ",")));

                else if (rowCounter >= CSVENTITIESBEGIN && rowCounter < CSVENTITIESEND) entities.add(parseArrayToEntities(parseCSVLineToStrings(line, ","), rowCounter - CSVENTITIESBEGIN));

                else {
                    entities.add(parseArrayToEntities(parseCSVLineToStrings(line, ","), rowCounter - CSVENTITIESBEGIN));
                    this.chunks.add(new ChunkModel(id, width, height, terrain, entities, neighbors));
                    rowCounter = 0;
                    neighbors = null;
                    terrain = new ArrayList<>();
                    entities = new ArrayList<>();
                }
            }
        } catch (NumberFormatException | IOException | NullPointerException e){
            e.printStackTrace();
        }
    }

    private ArrayList<MapEntityModel> parseArrayToEntities(ArrayList<String> array, int row) {
        ArrayList<MapEntityModel> result = new ArrayList<>();
        int column = 0;
        for (String value : array){
            result.add(new MapEntityModel(new Position(column, row), value));
            column++;
        }
        //TODO Position dilemma: MapEntityModel inherits from EntityModel, should there be a MapEntityView ?
        return result;
    }

    private ArrayList<MapTerrainModel> parseArrayToTerrain (ArrayList<Integer> array){
        ArrayList<MapTerrainModel> result = new ArrayList<>();
        for (Integer value : array)
            result.add(new MapTerrainModel(value));
        return result;
    }

    //TODO put in utils
    private ArrayList<Integer> parseCSVLineToIntegers (String line, String splitBy) throws NumberFormatException{
        ArrayList<Integer> values = new ArrayList<>();
        String[] characters = line.split(splitBy);
        for (String s : characters) values.add(Integer.parseInt(s));
        return values;
    }

    //TODO put in utils
    private ArrayList<String> parseCSVLineToStrings (String line, String splitBy) {
        String[] characters = line.split(splitBy);
        return new ArrayList<>(Arrays.asList(characters));
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
