public class WrongRequest implements Command{
    @Override
    public String execute(String request, Automobile automobile) {
        return "Not existing command";
    }
}
