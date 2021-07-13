import java.io.File;
import java.util.List;

public interface FigureAction<T extends AbstractFigure> {
    List<T> createFromFile(File file) throws ServiceException;
    double countArea(AbstractFigure figure);
    double countCapacity(AbstractFigure figure);
}
