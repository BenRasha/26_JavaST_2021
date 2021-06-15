import java.util.Objects;

public class Data {

    private int lowerBorder;
    private int higherBorder;
    private int step;

    public Data(int lowerBorder, int higherBorder, int step) {
        this.lowerBorder = lowerBorder;
        this.higherBorder = higherBorder;
        this.step = step;
    }

    public int getLowerBorder() {
        return lowerBorder;
    }

    public void setLowerBorder(int lowerBorder) {
        this.lowerBorder = lowerBorder;
    }

    public int getHigherBorder() {
        return higherBorder;
    }

    public void setHigherBorder(int higherBorder) {
        this.higherBorder = higherBorder;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return lowerBorder == data.lowerBorder && higherBorder == data.higherBorder && step == data.step;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lowerBorder, higherBorder, step);
    }
}
