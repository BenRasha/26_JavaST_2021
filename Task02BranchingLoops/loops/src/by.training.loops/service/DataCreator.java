import java.util.ArrayList;
import java.util.List;

public class DataCreator {

    private List<Data> data = new ArrayList<>();
    private FileOpener fileOpener = new FileOpener();

    /**
     * Reads information from the file and creates data according to given pattern in Data class.
     * @return list of Data read from file.
     */

    public List<Data> createData() throws IllegalArgumentException {
        List<String> strings = fileOpener.parseResourceFile();
        String []separator;
        for (int i = 0; i < strings.size(); i++) {
            separator = strings.get(i).split(" ");
            if (separator.length != 3) {
                throw new IllegalArgumentException("Not enough or more elements");
            }
            data.add(new Data(Integer.parseInt(separator[0]), Integer.parseInt(separator[1]), Integer.parseInt(separator[2])));
        }
        return data;
    }

}
