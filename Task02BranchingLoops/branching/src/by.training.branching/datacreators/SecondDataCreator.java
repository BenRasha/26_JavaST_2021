import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class SecondDataCreator {
    private List<Data> secondTask = new ArrayList<>();

    /**
     * Used to create and validate data for the second task
     * @return array list with data, created using constructor with 2 parameters.
     * @throws NumbersException custom exception with constructor that's parsing String message.
     */

    public List<Data> createData () throws NumbersException, FileNotFoundException {
        String source = "src/by.training.branching/resources/secondTask.txt";
        FileOpener fileOpener = new FileOpener();
        List<String> data = fileOpener.readFile(source);
        String [] separator;
        for (int i = 0; i < data.size(); i++) {
            separator = data.get(i).split(" ");
            if (separator.length != 2) {
                throw new NumbersException("Not enough elements to create object");
            } else if (separator[0].equals(separator[1])) {
                throw new NumbersException("Numbers can't be equal");
            }
            secondTask.add(new Data(Integer.parseInt(separator[0]), Integer.parseInt(separator[1])));
        }
        return secondTask;
    }
}
