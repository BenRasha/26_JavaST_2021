import java.util.ArrayList;
import java.util.List;

public class Automobile {

    private List<Wheel> wheels = new ArrayList<>(4);
    private Engine engine;
    private String brand;

    public Automobile(List<Wheel> wheels, Engine engine, String brand) {
        this.wheels = wheels;
        this.engine = engine;
        this.brand = brand;
    }

    public List<Wheel> getWheels() {
        return wheels;
    }

    public Wheel getWheel(int index) {
        return wheels.get(index);
    }

    public void setWheels(List<Wheel> wheels) {
        this.wheels = wheels;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Automobile{" +
                "wheels=" + wheels +
                "\n engine=" + engine +
                "\n brand='" + brand + '\'' +
                '}';
    }
}
