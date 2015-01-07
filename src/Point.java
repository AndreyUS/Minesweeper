public class Point {
    private int n;
    private int m;
    private boolean isMine;
    private int count = 0;

    Point(int n, int m, boolean isMine) {
        this.n = n;
        this.m = m;
        this.isMine = isMine;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public boolean isMine() {
        return this.isMine;
    }

    public void incrementCount() {
        if (!this.isMine) {
            this.count++;
        }
    }

    @Override
    public String toString() {
        if (this.isMine) {
            return "*";
        } else {
            return "" + count;
        }
    }
}
