import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.AssertJUnit.assertEquals;

public class MatrixDAOImplTest {

    private MatrixDAOImpl matrixDAO = new MatrixDAOImpl();

    @DataProvider(name = "PositiveDataForMatrixCreationFromFile")
    public Object[][] createDataForMatrixCreationFromFile() {
        return new Object[][] {
                {"src/by.training.task03DecompositionLayeredArchitecture/resources/matrix.txt", new int[][]{{3, 5, 8},{5, 7, 8},{1, 2, 8}}},
        };
    }

    @Test(description = "Positive scenario for matrix creation from file", dataProvider = "PositiveDataForMatrixCreationFromFile")
    public void testFillMatrixFromFile(String source, int[][] c) throws MatrixException, DAOException {
        Matrix actual = new Matrix(3,3);
        matrixDAO.createFromFile(actual, new File(source));
        Matrix expected = new Matrix(c);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(actual.getValue(i, j), expected.getValue(i, j));
            }
        }
    }

}
