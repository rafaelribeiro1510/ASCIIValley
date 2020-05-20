package com.g64.model;

import com.g64.exceptions.CrossedRight;
import com.g64.exceptions.CrossedUp;
import com.g64.exceptions.CrossedDown;
import com.g64.exceptions.CrossedLeft;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Position position) { return (this.x == position.x && this.y == position.y); }

    public double distanceTo(Position that) { return Math.sqrt(Math.pow(this.getX() - that.getX(), 2) + Math.pow(this.getY() - that.getY(), 2)); }

    public double horizontalDifference(Position that) { return this.getX() - that.getX(); }

    public double verticalDifference(Position that) { return this.getY() - that.getY(); }

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

    public Position checkDown(int height) throws CrossedDown {
        if (this.y + 1 < height) return new Position(this.x, this.y + 1);
        else throw new CrossedDown();
    }

    public Position checkUp(int height) throws CrossedUp {
        if (this.y - 1 >= 0) return new Position(this.x, this.y - 1);
        else throw new CrossedUp();
    }

    public Position checkLeft(int width) throws CrossedLeft {
        if (this.x - 1 >= 0) return new Position(this.x - 1, this.y);
        else throw new CrossedLeft();
    }

    public Position checkRight(int width) throws CrossedRight {
        if (this.x + 1 < width) return new Position(this.x + 1, this.y);
        else throw new CrossedRight();
    }

}
