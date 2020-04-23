package model;


import model.entities.Player;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MapModel {
    private int width;
    private int height;

    private Player player;

    private ArrayList<ChunkModel> chunks;

    public MapModel(int width, int height, Player player) {
        this.width = width;
        this.height = height;
        this.player = player;
    }
    // This right?? vv
    public Player getPlayer(){ return player; }

    public void setChunks(ArrayList<ChunkModel> chunks) {
        this.chunks = chunks;
    }

    // Reads the Map From a CSV File (whose name is at least for now hard-coded in)
    public void readMap() throws FileNotFoundException {
        int rowCounter = 0;
        ArrayList<ArrayList<Integer> > values = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("chunks.csv"));) {
            while (scanner.hasNextLine()) {

                parseLine(scanner.nextLine());

                rowCounter++;

                // parse Chunk
                if ((rowCounter % 15) == 0) {

                    // chunk id is the first value of the first line (index 0)
                    int chunkId = values.get(0).get(0);

                    // neighbours are on the first line: indexes 1,2,3,4 (North, East, South, West)
                    ArrayList<Integer> neighbourChunks = (ArrayList<Integer>) values.get(0).subList(1, 5);

                    // terrain matrix is the rest of the array
                    ArrayList<ArrayList<Integer> > terrain = (ArrayList<ArrayList<Integer>>) values.subList(1, 16);

                    chunks.add(new ChunkModel(width, height, terrain, chunkId, neighbourChunks));
                }
            }
        }
        this.setChunks(chunks);
    }

    // Parses a line of a CSV File
    private ArrayList<Integer> parseLine (String line) {
        ArrayList<Integer> values = new ArrayList<>();

        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(";");
            while (rowScanner.hasNext()) {
                values.add(Integer.parseInt(rowScanner.next()));
            }
        }
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
