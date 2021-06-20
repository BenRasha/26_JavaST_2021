public class WrongRequest implements Command{
    @Override
    public String execute(String request) {
        return "You've requested command, that doesn't exist";
    }
}
