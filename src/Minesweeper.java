import java.util.List;

public class Minesweeper {
    private Point[][] points;
    //Method check is int valid 0 < n < 100
    public boolean isValid(int n) {
        if (n <= 0 || n > 100) {
            return false;
        }
        return true;
    }
    // Method create the line.With using objects of class Point.
    // "*" it will be mine
    // "." it will be simple point with count of mine in environment
    public Point[] getLine(String line, Point[] linePoints, int n) {
        for (int i = 0; i < line.length(); i++) {
            switch (line.charAt(i)) {
                case '*':
                    linePoints[i] = new Point(n, i, true);
                    break;
                case '.':
                    linePoints[i] = new Point(n, i, false);
                    break;
                default:
                    System.exit(1);
                    break;
            }
        }
        return linePoints;
    }

    public Field generateField(Point[][] points, int count) {
        this.points = points;
        // search mines on field
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                if (points[i][j].isMine()) {
                    foundMine(points[i][j], points.length - 1, points[i].length - 1);
                }
            }
        }
        return new Field(this.points, count);
    }

    public void showFields(List<Field> fields) {
        for (Field field : fields) {
            if (field.getCount() != 1) {
                System.out.println();
            }
            System.out.println("Field #" + field.getCount() + ":");
            Point[][] points1 = field.getPoints();
            for (int i = 0; i < points1.length; i++) {
                for (int j = 0; j < points1[i].length; j++) {
                    System.out.print(points1[i][j].toString());
                }
                System.out.println();
            }
        }
    }
    // If find the mine. This method will call all near point.
    private void foundMine(Point point, int maxN, int maxM) {
        //If previous line is exist will increment all points on line
        if (isBorder(point.getN() - 1, maxN)) {
            changeLine(point, point.getN() - 1, maxM);
        }
        // Increment all points on same line.
        changeLine(point, point.getN(), maxM);
        // If next line is exist will increment all point on line.
        if (isBorder(point.getN() + 1, maxN)) {
            changeLine(point, point.getN() + 1, maxM);
        }

    }
    private void changeLine(Point point, int n , int maxM) {
        if (isBorder(point.getM() - 1, maxM)) {
            this.points[n][point.getM() - 1].incrementCount();
        }
        if (isBorder(point.getM(), maxM)) {
            this.points[n][point.getM()].incrementCount();
        }
        if (isBorder(point.getM() + 1, maxM)) {
            this.points[n][point.getM() + 1].incrementCount();
        }
    }
    // The method checks whether such a integer exists within the field.
    private boolean isBorder(int n, int max) {
        return n >= 0 && n <= max;
    }

}
