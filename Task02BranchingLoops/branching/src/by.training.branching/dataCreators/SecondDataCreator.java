import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class SecondDataCreator {

    private List<Data> secondTask = new ArrayList<>();

    public List<Data> createData() throws FileNotFoundException, NumbersException {
        String source = "C:\\26_JavaST_2021\\Task02BranchingLoops\\branching\\src\\by.training.branching\\resources\\secondTask.txt";
        FileOpener fileOpener = new FileOpener();
        List<String> data = fileOpener.readFile(source);
        String[] split;
        for (int i = 0; i < data.size(); i++) {
            split = data.get(i).split(" ");
            if (split.length != 2) {
                throw new NumbersException("Not enough elements");
            } else if (Integer.parseInt(split[0]) == Integer.parseInt(split[1])) {
                throw new NumbersException("Numbers can't be equal");
            }
            secondTask.add(new Data(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
        }
        return secondTask;
    }

}
