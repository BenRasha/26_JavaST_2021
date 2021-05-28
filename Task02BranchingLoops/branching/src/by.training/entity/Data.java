public class Data {

    /**
     * This is an entity class for all 5 tasks for branching. All parameters represent variables in tasks equations.
     * Contains different constructors for each task.
     */

    private int x;
    private int a;
    private int b;
    private int c;

    public Data (int x, int a, int b, int c) {
        this.x = x;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Data (int x, int a) {
        this.x = x;
        this.a = a;
    }

    public Data (int x, int a, int b) {
        this.x = x;
        this.a = a;
        this.b = b;
    }

    public Data (int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

}
