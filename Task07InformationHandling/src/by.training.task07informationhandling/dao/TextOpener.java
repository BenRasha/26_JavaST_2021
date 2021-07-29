import java.io.File;

public interface TextOpener {

    String getText(File file) throws DAOException;

}
