import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class MatrixMultiplicatorTest {

    private MatrixMultiplicator matrixMultiplicator = new MatrixMultiplicator();

    @DataProvider(name = "PositiveScenarioForMatrixMultiplication")
    public Object[][] createDataForMatrixMultiplication() {
        return new Object[][] {
                {new int[][]{{42, 66, 128},{58,90,160},{21,35,88}}}
        };
    }

    @Test(description = "", dataProvider = "PositiveScenarioForMatrixMultiplication")
    public void testMultiplyMatrix(int[][] c) throws ServiceException, MatrixException {
        Matrix p = new Matrix();
        Matrix q = new Matrix();
        Matrix actual = matrixMultiplicator.completeOperation(p, q);
        Matrix expected = new Matrix(c);
        for (int i = 0; i < actual.getVerticalSize(); i++) {
            for (int j = 0; j < actual.getHorizontalSize(); j++) {
                assertEquals(expected.getValue(i, j), actual.getValue(i, j));
            }
        }
    }

}
