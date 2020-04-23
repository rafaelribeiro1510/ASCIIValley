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
}
