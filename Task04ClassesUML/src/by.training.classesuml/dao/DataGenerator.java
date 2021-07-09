public interface DataGenerator {

    public Wheel generateWheel();
    public Engine generateEngine();
    public void writeWheelIntoFile(String source, Wheel wheel) throws DAOException;
    public void writeEngineIntoFile(String source, Engine engine) throws DAOException;

}
