import java.text.DecimalFormat;
import java.util.Objects;

public class Engine {

    private String brand;
    private double power;
    private boolean isFull;

    public Engine(String brand, double power) {
        this.brand = brand;
        this.power = power;
    }

    public Engine(String brand, double power, boolean isFull) {
        this.brand = brand;
        this.power = power;
        this.isFull = isFull;
    }

    public Engine() {

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return "Engine{" +
                "brand='" + brand + '\'' +
                ", power=" + decimalFormat.format(power) +
                ", isFull=" + isFull +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return Double.compare(engine.power, power) == 0 && isFull == engine.isFull && Objects.equals(brand, engine.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, power, isFull);
    }
}
