import java.util.List;

public interface AutomobileService {
    public Automobile createAutomobile(List<Wheel>wheels, Engine engine);
    public boolean isDrivable(Automobile automobile);
    public void changeWheel(Automobile automobile) throws ServiceException;
    public void chargeEngine(Automobile automobile);
    public String printAutomobileBrand(Automobile automobile);
}
