public class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();
    private final TextOpener textOpener = new TextOpenerImpl();

    private DAOFactory() {}

    public static DAOFactory getInstance() {
        return instance;
    }

    public TextOpener getTextOpener() {
        return textOpener;
    }

}
