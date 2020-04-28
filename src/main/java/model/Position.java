package model;

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

    public Position up() {
        return new Position(this.x, this.y - 1);
    }

    public Position right() {
        return new Position(this.x + 1, this.y);
    }

    public Position down() {
        return new Position(this.x, this.y + 1);
    }

    public Position left() {
        return new Position(this.x - 1, this.y);
    }

}
