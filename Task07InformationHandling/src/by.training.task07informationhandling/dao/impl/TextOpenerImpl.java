import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextOpenerImpl implements TextOpener {

    private static final int EMPTY = 0;


    @Override
    public String getText(File file) throws DAOException {
        String result;
        if (!file.exists() || file.length() == EMPTY) {
            throw new DAOException(new FileNotFoundException());
        }
        try {
            result = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));

        } catch (IOException exception) {
            throw new DAOException(exception);
        }
        return result;
    }
}
