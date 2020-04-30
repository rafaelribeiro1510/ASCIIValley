package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Utils {
    private static final String CSV_DELIMITER = ",";
    private static final int CSV_ID = 1;
    private static final int CSV_NEIGHBORS = 2;
    private static final int CSV_TERRAIN_START = 3;
    private static final int CSV_TERRAIN_END = 17;
    private static final int CSV_ENTITIES_START = 18;
    private static final int CSV_ENTITIES_END = 32;

    public static boolean parseCSVLineIntoObject (String line, int rowCounter, ChunkModel newChunk){
        if (rowCounter == CSV_ID) newChunk.setId(Integer.parseInt(line));

        else if (rowCounter == CSV_NEIGHBORS) newChunk.setNeighbours(parseCSVLineToIntegers(line));

        else if (rowCounter >= CSV_TERRAIN_START && rowCounter <= CSV_TERRAIN_END) newChunk.addTerrainLine(parseArrayToTerrain(Utils.parseCSVLineToIntegers(line)));

        else if (rowCounter >= CSV_ENTITIES_START && rowCounter <= CSV_ENTITIES_END) newChunk.addEntityLine(parseArrayToEntities(Utils.parseCSVLineToStrings(line), rowCounter - CSV_ENTITIES_START));

        return (rowCounter == CSV_ENTITIES_END);
    }

    private static ArrayList<Integer> parseCSVLineToIntegers(String line) {
        ArrayList<Integer> values = new ArrayList<>();
        String[] characters = line.split(CSV_DELIMITER);
        for (String s : characters) values.add(Integer.parseInt(s));
        return values;
    }

    private static ArrayList<String> parseCSVLineToStrings(String line) {
        String[] characters = line.split(CSV_DELIMITER);
        return new ArrayList<>(Arrays.asList(characters));
    }

    private static ArrayList<MapEntityModel> parseArrayToEntities(ArrayList<String> array, int row) {
        ArrayList<MapEntityModel> result = new ArrayList<>();
        int column = 0;
        for (String value : array){
            result.add(new MapEntityModel(new Position(column, row), value));
            column++;
        }
        return result;
    }

    private static ArrayList<MapTerrainModel> parseArrayToTerrain (ArrayList<Integer> array){
        ArrayList<MapTerrainModel> result = new ArrayList<>();
        for (Integer value : array)
            result.add(new MapTerrainModel(value));
        return result;
    }
}
