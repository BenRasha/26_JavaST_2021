import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ThirdDataCreator {

    private List<Data> thirdTask = new ArrayList<>();

    public List<Data> createData() throws FileNotFoundException, NumbersException {
        String source = "C:\\26_JavaST_2021\\Task02BranchingLoops\\branching\\src\\by.training.branching\\resources\\thirdTask.txt";
        FileOpener fileOpener = new FileOpener();
        List<String> data = fileOpener.readFile(source);
        String[] split;
        for (int i = 0; i < data.size(); i++) {
            split = data.get(i).split(" ");
            if (split.length != 2) {
                throw new NumbersException("Not enough elements");
            } else if (Integer.parseInt(split[0]) < 0 || Integer.parseInt(split[0]) > 31) {
                throw new NumbersException("Wrong number format");
            } else if (Integer.parseInt(split[1]) < 0 || Integer.parseInt(split[1]) > 12) {
                throw new NumbersException("Wrong number format");
            }
            thirdTask.add(new Data(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
        }
        return thirdTask;
    }

}
