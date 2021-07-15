import java.util.Arrays;

public class Matrix {

    private int[][] values;

    public Matrix() {}

    public Matrix(int[][] values) {
        this.values = values;
    }

    public Matrix(int rows, int columns) {
        values = new int[rows][columns];
    }

    public int getVerticalSize() {
        return values.length;
    }

    public int getHorizontalSize() {
        return values[0].length;
    }

    public void setValue(int i, int j, int value) throws MatrixException {
        if (checkRange(i, j)) {
            values[i][j] = value;
        } else {
            throw new MatrixException();
        }
    }

    public int getValue(int i, int j) throws MatrixException {
        if (checkRange(i, j)) {
            return values[i][j];
        } else {
            throw new MatrixException();
        }
    }

    public int[][] getValues() {
        return values;
    }

    @Override
    public String toString() {
        final String BLANK = " ";
        StringBuilder s = new StringBuilder("\nMatrix : " + values.length + "x" + values[0].length + "\n");
        for (int [] row : values) {
            for (int  value : row) {
                s.append(value).append(BLANK);
            }
            s.append("\n");
        }
        return s.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return Arrays.equals(values, matrix.values);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }

    private boolean checkRange(int i, int j) {
        if (i < 0 || i > values.length - 1 || j < 0 || j > values[0].length - 1) {
            return false;
        } else {
            return true;
        }
    }

}
