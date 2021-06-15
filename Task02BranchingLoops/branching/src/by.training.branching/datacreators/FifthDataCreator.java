import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class FifthDataCreator {

    private List<Data> fifthTask = new ArrayList<>();

    /**
     * Used to create and validate data for the fifth task.
     * @return array list of data, created using constructor with 1 parameter.
     */

    public List<Data> createData () throws FileNotFoundException {
        String source = "src/by.training.branching/resources/fifthTask.txt";
        FileOpener fileOpener = new FileOpener();
        List<String> data = fileOpener.readFile(source);
        for (int i = 0; i < data.size(); i++) {
            fifthTask.add(new Data(Integer.parseInt(data.get(i))));
        }
        return fifthTask;
    }
}
