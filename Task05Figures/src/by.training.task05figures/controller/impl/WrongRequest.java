public class WrongRequest implements Command{
    @Override
    public double execute(String request, Pyramid pyramid) {
        System.out.println("Not existing command");
        return 0;
    }
}
