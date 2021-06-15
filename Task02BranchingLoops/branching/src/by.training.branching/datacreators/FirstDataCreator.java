import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class FirstDataCreator {

    private List<Data>fstTask = new ArrayList<>();

    /**
     * Used to create and validate data for the first task.
     * @return array list of data created using constructor with 4 parameters.
     * @throws NumbersException custom exception with constructor that parses String message.
     */

    public List<Data> createData () throws FileNotFoundException, NumbersException {
        String source = "C:\\26_JavaST_2021\\Task02BranchingLoops\\branching\\src\\by.training.branching\\resources\\firstTask.txt";
        FileOpener fileOpener = new FileOpener();
        List<String> data = fileOpener.readFile(source);
        String [] separator;
        for (int i = 0; i < data.size(); i++) {
            separator = data.get(i).split(" ");
            if (separator.length != 4) {
                throw new NumbersException("Not enough elements to create object");
            }
            fstTask.add(new Data(Integer.parseInt(separator[0]), Integer.parseInt(separator[1]), Integer.parseInt(separator[2]), Integer.parseInt(separator[3])));
        }
        return fstTask;
    }
}
