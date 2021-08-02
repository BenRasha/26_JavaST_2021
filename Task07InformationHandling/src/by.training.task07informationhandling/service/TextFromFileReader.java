import java.io.File;

public class TextFromFileReader {

    public String getText(File file) throws ServiceException {
        String text = "";
        DAOFactory daoFactory = DAOFactory.getInstance();
        TextOpener textOpener = daoFactory.getTextOpener();
        try {
            text = textOpener.getText(file);
        } catch (DAOException exception) {
            throw new ServiceException(exception);
        }
        return text;
    }

}
