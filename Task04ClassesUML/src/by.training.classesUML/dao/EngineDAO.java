import java.io.File;

public interface EngineDAO {
    public Engine createEngineFromFile(File file) throws DAOException;
}
