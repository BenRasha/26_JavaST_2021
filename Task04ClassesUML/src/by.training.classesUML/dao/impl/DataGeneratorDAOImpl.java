import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DataGeneratorDAOImpl implements DataGenerator{

    private final Random random = new Random();
    private static final List<EngineBrands> VALUES = Collections.unmodifiableList(Arrays.asList(EngineBrands.values()));
    private static final int SIZE = VALUES.size();

    @Override
    public Wheel generateWheel() {
        Wheel wheel = new Wheel();
        wheel.setSize(random.nextDouble() * 20);
        wheel.setDiameter(random.nextDouble() * 30);
        wheel.setRepaired(random.nextBoolean());
        return wheel;
    }

    @Override
    public Engine generateEngine() {
        Engine engine = new Engine();
        engine.setBrand(VALUES.get(random.nextInt(SIZE)).toString().toLowerCase());
        engine.setPower(random.nextDouble() * 160);
        engine.setFull(random.nextBoolean());
        return engine;
    }

    @Override
    public void writeWheelIntoFile(String source, Wheel wheel) throws DAOException {
        File fileToWrite = new File(source);
        try (FileWriter fileWriter = new FileWriter(fileToWrite, true)){
            fileWriter.write(wheel.getSize() + " " + wheel.getDiameter() + " " + wheel.isRepaired() + "\n");
        } catch (IOException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void writeEngineIntoFile(String source, Engine engine) throws DAOException {
        File fileToWrite = new File(source);
        try (FileWriter fileWriter = new FileWriter(fileToWrite,true)) {
            fileWriter.write(engine.getBrand() + " " + engine.getPower() + " " + engine.isFull() + "\n");
        } catch (IOException exception) {
            throw new DAOException(exception);
        }
    }
}
