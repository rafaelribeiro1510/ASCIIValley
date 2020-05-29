package com.g64.model;

import com.googlecode.lanterna.TextColor;
import com.g64.model.entities.map.MapEntityFactory;
import com.g64.model.entities.map.MapEntity;
import com.g64.model.terrain.MapTerrain;
import com.g64.model.terrain.MapTerrainFactory;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Utils {
    private static final String CSV_DELIMITER = ",";
    private static final int    CSV_ID = 1;
    private static final int    CSV_NEIGHBORS = 2;
    private static final int    CSV_TERRAIN_START = 3;
    private static final int    CSV_TERRAIN_END = 17;
    private static final int    CSV_ENTITIES_START = 18;
    private static final int    CSV_ENTITIES_END = 32;

    public static boolean parseCSVLineIntoObject (String line, int rowCounter, ChunkModel newChunk){
        if (rowCounter == CSV_ID) newChunk.setId(Integer.parseInt(line));

        else if (rowCounter == CSV_NEIGHBORS) newChunk.setNeighbours(parseCSVLineToIntegers(line));

        else if (rowCounter >= CSV_TERRAIN_START && rowCounter <= CSV_TERRAIN_END) newChunk.addTerrainLine(parseArrayToTerrain(Utils.parseCSVLineToIntegers(line), rowCounter - CSV_TERRAIN_START));

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

    private static ArrayList<MapEntity> parseArrayToEntities(ArrayList<String> array, int row) {
        ArrayList<MapEntity> result = new ArrayList<>();
        int column = 0;
        for (String string : array){
            MapEntity entity = MapEntityFactory.get(new Position(column, row), string);
            if (entity != null) result.add(entity);
            column++;
        }
        return result;
    }

    private static ArrayList<MapTerrain> parseArrayToTerrain (ArrayList<Integer> array, int row){
        ArrayList<MapTerrain> result = new ArrayList<>();
        int column = 0;
        for (Integer integer : array) {
            MapTerrain terrain = MapTerrainFactory.get(new Position(column, row), integer);
            if (terrain != null) result.add(terrain);
            column++;
        }
        return result;
    }


    public static void parseObjectIntoCSVLine(BufferedWriter bw, ChunkModel chunk) {
        try {
            writeIdLine(bw, chunk);
            writeNeighboursLine(bw, chunk);
            writeTerrainLines(bw, chunk);
            writeEntityLines(bw, chunk);

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeIdLine(BufferedWriter bw, ChunkModel chunk) throws IOException {
        bw.write(String.valueOf(chunk.getId()) + "\n");
    }

    private static void writeNeighboursLine(BufferedWriter bw, ChunkModel chunk) throws IOException {
        String neighboursLine = chunk.getNorthId() + "," +
                chunk.getSouthId() + "," +
                chunk.getEastId() + "," +
                chunk.getWestId() + "\n";
        bw.write(neighboursLine);
    }

    private static void writeTerrainLines(BufferedWriter bw, ChunkModel chunk) throws IOException {

        Map<Color, Integer> tMapInverted = new HashMap<Color, Integer>() {{
            put(new TextColor.RGB(0, 0, 0).toColor(),         0); // Null
            put(new TextColor.RGB(0, 102, 0).toColor(),       1); //Grass
            put(new TextColor.RGB(204, 153, 0).toColor(),     2); //Sand
            put(new TextColor.RGB(102, 51, 0).toColor(),      3); //Dirt
            put(new TextColor.RGB(0, 153, 255).toColor(),     4); //Water
            put(new TextColor.RGB(105, 105, 105).toColor(),   5); //Stone
        }};

        StringBuilder terrainLine = new StringBuilder();

        for (int row = 0; row < 15; row++) {
            for (int col = 0; col < 40; col++) {

                if (col != 0) terrainLine.append(",");

                TextColor posColor = chunk.getTerrainAt(new Position(col,row)).getColor();
                terrainLine.append(tMapInverted.get(posColor.toColor()));
            }
            // if (row + 1 < 15)
            terrainLine.append("\n");
            bw.write(terrainLine.toString());

            terrainLine = new StringBuilder(); // "clearing" the StringBuilder
        }

    }

    private static void writeEntityLines(BufferedWriter bw, ChunkModel chunk) throws IOException {

        Map<Color, String> eMapInverted = new HashMap<Color, String>() {{
            put(new TextColor.RGB(40,40,40).toColor(),      "^"); // Stone
            put(new TextColor.RGB(0, 204, 255).toColor(),   "~"); // Water
            put(new TextColor.RGB(26, 12, 0).toColor(),     ":"); // Dirt
            put(new TextColor.RGB(0, 204, 0).toColor(),     "y"); // Grass patch
        }};

        StringBuilder entityLine = new StringBuilder();

        for (int row = 0; row < 15; row++) {
            for (int col = 0; col < 40; col++) {

                if (col != 0) entityLine.append(",");

                TextColor entityColor = chunk.getEntityAt(new Position(col, row)).getColor();

                String entityString;
                if ( (entityString = eMapInverted.get(entityColor.toColor())) != null) {
                    entityLine.append(entityString);
                }
                else { entityLine.append(" "); }
            }

            if (row + 1 < 15) entityLine.append("\n");
            bw.write(entityLine.toString());

            entityLine = new StringBuilder(); // "clearing" the StringBuilder
        }
    }
}
