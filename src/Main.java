import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean flag = true;
        int count = 0;
        int n, m;
        Scanner scanner = new Scanner(System.in);
        Point[][] points;
        List<Field> fields = new ArrayList<Field>();
        Minesweeper minesweeper = new Minesweeper();
        while (flag) {
            count++;
            try {
                n = scanner.nextInt();
                m = scanner.nextInt();
                // check input int
                if (!minesweeper.isValid(n) && !minesweeper.isValid(m)) {
                    flag = false;
                    break;
                }
                // Create array and read n-lines
                points = new Point[n][m];
                for (int i = 0; i < n; i++) {
                    String line = scanner.next();
                    points[i] = minesweeper.getLine(line, points[i], i);
                }
                fields.add(minesweeper.generateField(points, count));
            } catch (Exception e) {
                System.exit(1);
            }

        }
        minesweeper.showFields(fields);
    }
}
