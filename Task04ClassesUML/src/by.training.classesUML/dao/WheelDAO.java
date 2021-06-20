import java.io.File;

public interface WheelDAO {
    public Wheel createWheelFromFile(File file) throws DAOException;
}
