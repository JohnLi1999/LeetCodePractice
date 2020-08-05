package utils.pair_node;

public class Pos {
    public int x;
    public int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object object) {
        Pos pos = (Pos) object;
        return this.x == pos.x && this.y == pos.y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ')';
    }
}
