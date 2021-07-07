import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PyramidStorage {

    static final Logger pyramidStorageLogger = LogManager.getLogger(PyramidStorage.class.getName());
    private static PyramidStorage storage = new PyramidStorage();
    private List<Pyramid> list = new ArrayList<>();

    private PyramidStorage() {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        FigureAction pyramidAction = serviceFactory.getPyramidAction();
        try {
            list = (List<Pyramid>) pyramidAction.createFromFile(new File("data.txt"));
        } catch (ServiceException exception) {
            pyramidStorageLogger.error("Error during creating storage", exception);
        }
    }

    public static PyramidStorage getStorage() {
        return storage;
    }

    public List<Pyramid> getAll() {
        return list;
    }

    public void setStorage(List<Pyramid> list) {
        this.list = list;
    }
}
