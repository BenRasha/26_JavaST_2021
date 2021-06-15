import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class FourthDataCreator {

    private List<Data> fourthTask = new ArrayList<>();

    /**
     * Used to create and validate data for the fourth task.
     * @return array list of data, created using constructor with 3 parameters.
     * @throws NumbersException custom exception with constructor that parses String message
     */

    public List<Data> createData () throws NumbersException, FileNotFoundException {
        String source = "src/by.training.branching/resources/fourthTask.txt";
        FileOpener fileOpener = new FileOpener();
        List<String> data = fileOpener.readFile(source);
        String [] separator;
        for (int i = 0; i < data.size(); i++) {
            separator = data.get(i).split(" ");
            if (separator.length != 3) {
                throw new NumbersException("Not enough elements to create object");
            } else if (Integer.parseInt(separator[0]) < 0 || Integer.parseInt(separator[1]) < 0 || Integer.parseInt(separator[2]) < 0) {
                throw new NumbersException("Incorrect number format");
            }
            fourthTask.add(new Data(Integer.parseInt(separator[0]), Integer.parseInt(separator[1]), Integer.parseInt(separator[2])));
        }
        return fourthTask;
    }
}
