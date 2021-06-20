import java.util.List;

public interface AutomobileCreator {
    public Automobile createAutomobile(List<Wheel>wheels, Engine engine);
    public boolean drive(Automobile automobile);
    public void changeWheel(Automobile automobile) throws ServiceException;
    public void chargeEngine(Automobile automobile);
    public String printAutomobileBrand(Automobile automobile);
}
