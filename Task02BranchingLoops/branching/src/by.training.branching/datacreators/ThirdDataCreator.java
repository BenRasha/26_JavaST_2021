import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ThirdDataCreator {

    private List<Data>thirdTask = new ArrayList<>();

    /**
     * Used to create and validate data for the third task
     * @return array list with data, created using constructor with 2 parameters.
     * @throws NumbersException custom exception with constructor that's parsing String message.
     */

    public List<Data> createData () throws NumbersException, FileNotFoundException {
        String source = "src/by.training.branching/resources/thirdTask.txt";
        FileOpener fileOpener = new FileOpener();
        List<String> data = fileOpener.readFile(source);
        String [] separator;
        for (int i = 0; i < data.size(); i++) {
            separator = data.get(i).split(" ");
            if (separator.length != 2) {
                throw new NumbersException("Not enough elements to create object");
            } else if (Integer.parseInt(separator[0]) < 0 || Integer.parseInt(separator[0]) > 31) {
                throw new NumbersException("Incorrect day date format");
            } else if (Integer.parseInt(separator[1]) < 0 || Integer.parseInt(separator[1]) > 12) {
                throw new NumbersException("Incorrect month date format");
            }
            thirdTask.add(new Data(Integer.parseInt(separator[0]), Integer.parseInt(separator[1])));
        }
        return thirdTask;
    }
}
