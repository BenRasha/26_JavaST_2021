import java.text.DecimalFormat;
import java.util.Objects;

public class Wheel {

    private double size;
    private double diameter;
    private boolean isRepaired;

    public Wheel(double size, double diameter) {
        this.size = size;
        this.diameter = diameter;
    }

    public Wheel(double size, double diameter, boolean isRepaired) {
        this.size = size;
        this.diameter = diameter;
        this.isRepaired = isRepaired;
    }

    public Wheel() {}

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public boolean isRepaired() {
        return isRepaired;
    }

    public void setRepaired(boolean repaired) {
        isRepaired = repaired;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return "Wheel{" +
                "size=" + decimalFormat.format(size) +
                ", diameter=" + decimalFormat.format(diameter) +
                ", isRepaired=" + isRepaired +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wheel wheel = (Wheel) o;
        return Double.compare(wheel.size, size) == 0 && Double.compare(wheel.diameter, diameter) == 0 && isRepaired == wheel.isRepaired;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, diameter, isRepaired);
    }
}
