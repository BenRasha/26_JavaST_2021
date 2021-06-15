import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class FifthDataCreator {

    private List<Data> fifthTask = new ArrayList<>();

    public List<Data> createData() throws FileNotFoundException {
        String source = "C:\\26_JavaST_2021\\Task02BranchingLoops\\branching\\src\\by.training.branching\\resources\\fifthTask.txt";
        FileOpener fileOpener = new FileOpener();
        List<String> data = fileOpener.readFile(source);
        for (int i = 0; i < data.size(); i++) {
            fifthTask.add(new Data(Integer.parseInt(data.get(i))));
        }
        return fifthTask;
    }

}
