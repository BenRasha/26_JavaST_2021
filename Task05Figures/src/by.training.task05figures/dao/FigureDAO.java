import java.io.File;
import java.util.List;

public interface FigureDAO {
    List<? extends AbstractFigure> createFromFile(File file) throws DAOException;
}
