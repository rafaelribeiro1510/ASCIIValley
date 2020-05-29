package com.g64.model;

import static java.lang.Math.abs;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Position)) return false;
        Position that = (Position) o;
        return (this.x == that.x && this.y == that.y);
    }

    public double distanceTo(Position that) { return Math.sqrt(Math.pow(this.getX() - that.getX(), 2) + Math.pow(this.getY() - that.getY(), 2)); }

    public double horizontalDifference(Position that) { return this.getX() - that.getX(); }

    public double verticalDifference(Position that) { return this.getY() - that.getY(); }

    public boolean adjacent(Position that) {
        return (
                (this.getX() == that.getX() && abs(verticalDifference(that)) == 1) ||
                (this.getY() == that.getY() && abs(horizontalDifference(that)) == 1)
        );
    }

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
