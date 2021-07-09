public class ShowBrandImpl implements Command{

    @Override
    public String execute(String request, Automobile automobile) {
        return automobile.getBrand();
    }

}
