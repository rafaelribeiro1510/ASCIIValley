package model.map;


import com.googlecode.lanterna.TextColor;
import model.Position;
import model.entities.MapEntityModel;
import model.entities.PlayerModel;
import view.CSVColors;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MapModel {
    private static final int CSVID = 1;
    private static final int CSVNEIGHBORS = 2;
    private static final int CSVTERRAINBEGIN = 3;
    private static final int CSVTERRAINEND = 17;
    private static final int CSVENTITIESBEGIN = 18;
    private static final int CSVENTITIESEND = 32;

    private int width;
    private int height;

    private PlayerModel playerModel;

    private int currentChunkID;
    private ArrayList<ChunkModel> chunks;

    public MapModel(int width, int height, PlayerModel playerModel, int currentChunkID) {
        this.width = width;
        this.height = height;
        this.playerModel = playerModel;
        this.chunks = new ArrayList<>();
        this.currentChunkID = currentChunkID;
        this.readMap();
    }
    // TODO This right?? vv
    public PlayerModel getPlayerModel(){ return playerModel; }

    public ChunkModel getChunk() {
        for (ChunkModel chunk : this.chunks)
            if (chunk.getId() == this.currentChunkID)
                return chunk;
        System.out.print("getChunkFailed\n");
        return null;
    }

    // Reads the Map From a CSV File (whose name is at least for now hard-coded in)
    public void readMap() {
        int id = 0;
        ArrayList<Integer> neighbors = null;
        ArrayList<ArrayList<TextColor>> terrain = new ArrayList<>();
        ArrayList<ArrayList<MapEntityModel>> entities = new ArrayList<>();

        String line = "";

        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/Rafael/Documents/GitHub/lpoo-2020-g64/src/main/java/model/map/chunks.csv"))) {
            int rowCounter = 0;

            while ((line = br.readLine()) != null) {
                rowCounter++;

                //Should be line instead of "1", cant fix
                if (rowCounter == CSVID) id = Integer.parseInt("1");

                else if (rowCounter == CSVNEIGHBORS) neighbors = parseCSVLineToIntegers(line, ",");

                else if (rowCounter >= CSVTERRAINBEGIN && rowCounter <= CSVTERRAINEND) terrain.add(parseArrayToColors(parseCSVLineToIntegers(line, ",")));

                else if (rowCounter >= CSVENTITIESBEGIN && rowCounter < CSVENTITIESEND) entities.add(parseArrayToEntities(parseCSVLineToStrings(line, ","), rowCounter - CSVENTITIESBEGIN));

                else {
                    entities.add(parseArrayToEntities(parseCSVLineToStrings(line, ","), rowCounter - CSVENTITIESBEGIN));
                    rowCounter = 0;
                    this.chunks.add(new ChunkModel(id, width, height, terrain, entities, neighbors));
                }
            }
        } catch (NumberFormatException | IOException | NullPointerException e){
            e.printStackTrace();
        }
    }

    private ArrayList<MapEntityModel> parseArrayToEntities(ArrayList<String> array, int row) {
        ArrayList<MapEntityModel> result = new ArrayList<>();
        int column = 1;
        for (String value : array){
            result.add(new MapEntityModel(new Position(column, row), value));
            column++;
        }
        //TODO Position dilemma: MapEntityModel inherits from EntityModel, should there be a MapEntityView ?
        return result;
    }

    private ArrayList<TextColor> parseArrayToColors (ArrayList<Integer> array){
        ArrayList<TextColor> result = new ArrayList<>();
        for (Integer value : array)
            result.add(new CSVColors(value).getRgb());
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
