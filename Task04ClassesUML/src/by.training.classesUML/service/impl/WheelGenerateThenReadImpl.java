import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WheelGenerateThenReadImpl implements GenerateToFileThenRead<Wheel> {

    private List<Wheel> wheels = new ArrayList<>();

    @Override
    public List<Wheel> generateThenRead() throws ServiceException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            DataGenerator wheelsGenerator = daoFactory.getDataGenerator();
            WheelDAO wheelDAO = daoFactory.getWheelDAO();
            String source = "src/by.training.classesUML/resources/wheelData.txt";
            for (int i = 0; i < 4; i++) {
                wheelsGenerator.writeWheelIntoFile(source, wheelsGenerator.generateWheel());
                wheels.add(wheelDAO.createWheelFromFile(new File(source)));
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return wheels;
    }
}
