package com.g64.model;

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

    public void moveUp() {
        this.y--;
    }

    public void moveDown() {
        this.y++;
    }

    public void moveLeft() {
        this.x--;
    }

    public void moveRight() {
        this.x++;
    }

    public Position lookUp() { return new Position(this.x, this.y - 1); }

    public Position lookDown() { return new Position(this.x, this.y + 1); }

    public Position lookLeft() { return new Position(this.x - 1, this.y); }

    public Position lookRight() { return new Position(this.x + 1, this.y); }
}
