package model;

import model.entities.Player;

public class MapModel {
    private int width;
    private int height;

    private Player player;

    public MapModel(int width, int height, Player player) {
        this.width = width;
        this.height = height;
        this.player = player;
    }
    // This right?? vv
    public Player getPlayer(){ return player; }

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
