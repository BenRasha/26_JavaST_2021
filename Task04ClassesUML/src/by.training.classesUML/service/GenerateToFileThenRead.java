import java.util.List;

public interface GenerateToFileThenRead <T> {
    public List<T> generateThenRead() throws ServiceException;
}
