import java.io.File;
import java.util.List;

public interface FigureAction {
    List<? extends AbstractFigure> createFromFile(File file) throws ServiceException;
    double countArea(AbstractFigure figure) throws ServiceException;
    double countCapacity(AbstractFigure figure) throws ServiceException;
}
