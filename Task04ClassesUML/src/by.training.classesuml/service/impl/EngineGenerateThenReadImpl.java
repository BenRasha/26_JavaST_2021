import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class EngineGenerateThenReadImpl implements GenerateToFileThenRead<Engine>{

    private List<Engine> engines = new ArrayList<>();

    @Override
    public List<Engine> generateThenRead() throws ServiceException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            DataGenerator engineGenerator = daoFactory.getDataGenerator();
            EngineDAO engineDAO = daoFactory.getEngineDAO();
            String source = "src/by.training.classesUML/resources/engineData.txt";
            engineGenerator.writeEngineIntoFile(source, engineGenerator.generateEngine());
            engines.add(engineDAO.createEngineFromFile(new File(source)));
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return engines;
    }
}
