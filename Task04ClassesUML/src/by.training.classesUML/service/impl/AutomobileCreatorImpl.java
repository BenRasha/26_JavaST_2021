import java.io.File;
import java.util.List;

public class AutomobileCreatorImpl implements AutomobileCreator{

    @Override
    public Automobile createAutomobile(List<Wheel>wheels, Engine engine) {
        DAOFactory daoFactory = DAOFactory.getInstance();
        AutomobileDAO automobileDAO = daoFactory.getAutomobileDAO();
        return automobileDAO.createAutomobiles(wheels, engine);
    }

    @Override
    public boolean drive(Automobile automobile) {
        if (wheelsCheck(automobile) && automobile.getEngine().isFull()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void changeWheel(Automobile automobile) throws ServiceException {
        for (Wheel wheel : automobile.getWheels()) {
            if (!wheel.isRepaired()) {
                try {
                    DAOFactory daoFactory = DAOFactory.getInstance();
                    DataGenerator wheelGenerator = daoFactory.getDataGenerator();
                    WheelDAO wheelDAO = daoFactory.getWheelDAO();
                    String source = "src/by.training.classesUML/resources/wheelData.txt";
                    wheelGenerator.writeWheelIntoFile(source, wheelGenerator.generateWheel());
                    wheel.setDiameter(wheelDAO.createWheelFromFile(new File(source)).getDiameter());
                    wheel.setSize(wheelDAO.createWheelFromFile(new File(source)).getSize());
                    wheel.setRepaired(true);
                } catch (DAOException e) {
                    throw new ServiceException(e);
                }
            }
        }
    }

    @Override
    public void chargeEngine(Automobile automobile) {
        if (!automobile.getEngine().isFull()) {
            automobile.getEngine().setFull(true);
        }
    }

    @Override
    public String printAutomobileBrand(Automobile automobile) {
        return automobile.getBrand();
    }

    private boolean wheelsCheck(Automobile automobile) {
        for (Wheel wheel : automobile.getWheels()) {
            if (!wheel.isRepaired()) {
                return false;
            }
        }
        return true;
    }
}
