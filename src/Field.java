public class Field {
    private Point[][] points;
    private int count;

    Field(Point[][] points, int count) {
        this.points = points;
        this.count = count;
    }

    public Point[][] getPoints() {
        return points;
    }

    public int getCount() {
        return count;
    }
}
