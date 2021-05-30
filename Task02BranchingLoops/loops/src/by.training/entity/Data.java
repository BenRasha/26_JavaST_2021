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
}
