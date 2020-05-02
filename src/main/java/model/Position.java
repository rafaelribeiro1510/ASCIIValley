package model;

import Exceptions.CrossedEast;
import Exceptions.CrossedNorth;
import Exceptions.CrossedSouth;
import Exceptions.CrossedWest;
import controller.GameController;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void up() {
        this.y--;
    }

    public void down() {
        this.y++;
    }

    public void left() {
        this.x--;
    }

    public void right() {
        this.x++;
    }

    public Position checkDown(int height) throws CrossedSouth {
        if (this.y + 1 < height) return new Position(this.x, this.y + 1);
        else throw new CrossedSouth();
    }

    public Position checkUp(int height) throws CrossedNorth {
        if (this.y - 1 >= 0) return new Position(this.x, this.y - 1);
        else throw new CrossedNorth();
    }

    public Position checkLeft(int width) throws CrossedWest {
        if (this.x - 1 >= 0) return new Position(this.x - 1, this.y);
        else throw new CrossedWest();
    }

    public Position checkRight(int width) throws CrossedEast {
        if (this.x + 1 < width) return new Position(this.x + 1, this.y);
        else throw new CrossedEast();
    }

}
