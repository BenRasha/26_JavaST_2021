import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PyramidDAOImpl implements FigureDAO{

    private final List<Pyramid> figures = new ArrayList<>();
    private static final String REGEX = "^((-?\\d*\\.{0,1}\\d+\\s?){12})$";
    private static final String SPACE = " ";
    private final Pattern pattern = Pattern.compile(REGEX);
    private static final List<PyramidNames> VALUES = Collections.unmodifiableList(Arrays.asList(PyramidNames.values()));
    private static final int SIZE = VALUES.size();
    private final Random random = new Random();

    @Override
    public List<Pyramid> createFromFile(File file) throws DAOException {
        try (Scanner scanner = new Scanner(new FileReader(file))) {
            String[] separator;
            while (scanner.hasNextLine()) {
                Matcher matcher = pattern.matcher(scanner.nextLine());
                if (matcher.find()) {
                    separator = matcher.group().split(SPACE);
                    figures.add(new Pyramid(VALUES.get(random.nextInt(SIZE)).toString().toLowerCase(), random.nextInt(5), Arrays.asList(
                            new AbstractFigure.Dot(Double.parseDouble(separator[0]), Double.parseDouble(separator[1]), Double.parseDouble(separator[2])),
                            new AbstractFigure.Dot(Double.parseDouble(separator[3]), Double.parseDouble(separator[4]), Double.parseDouble(separator[5])),
                            new AbstractFigure.Dot(Double.parseDouble(separator[6]), Double.parseDouble(separator[7]), Double.parseDouble(separator[8])),
                            new AbstractFigure.Dot(Double.parseDouble(separator[9]), Double.parseDouble(separator[10]), Double.parseDouble(separator[11])))));
                }
            }
        } catch (FileNotFoundException e) {
            throw new DAOException(e);
        }
        return figures;
    }
}
