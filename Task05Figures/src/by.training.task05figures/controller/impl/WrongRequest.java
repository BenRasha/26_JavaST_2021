public class WrongRequest implements Command{
    @Override
    public Pyramid execute(String request) {
        System.out.println("Not existing command");
        return null;
    }
}
