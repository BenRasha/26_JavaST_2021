import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class FirstDataCreator {

    private List<Data> firstTask = new ArrayList<>();

    public List<Data> createData() throws FileNotFoundException, NumbersException {
        String source = "C:\\26_JavaST_2021\\Task02BranchingLoops\\branching\\src\\by.training.branching\\resources\\firstTask.txt";
        FileOpener fileOpener = new FileOpener();
        List<String> data = fileOpener.readFile(source);
        String[] split;
        for (int i = 0; i < data.size(); i++) {
            split = data.get(i).split(" ");
            if (split.length != 4) {
                throw new NumbersException("Not enough elements");
            }
            firstTask.add(new Data(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3])));
        }
        return firstTask;
    }
}
