import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class MatrixSummatorTest {

    private MatrixSummator summator = new MatrixSummator();

    @DataProvider(name = "PositiveDataForMatrixSum")
    public Object[][] createDataForMatrixSum() {
        return new Object[][] {
                {new int[][]{{6, 10, 16}, {10, 14, 16}, {2, 4, 16}}}
        };
    }

    @Test(description = "Positive scenario for matrix sum", dataProvider = "PositiveDataForMatrixSum")
    public void testMatrixSum(int[][] c) throws MatrixException, ServiceException {
        Matrix p = new Matrix();
        Matrix q = new Matrix();
        Matrix actual = summator.completeOperation(p, q);
        Matrix expected = new Matrix(c);
        for (int i = 0; i < actual.getVerticalSize(); i++) {
            for (int j = 0; j < actual.getHorizontalSize(); j++) {
                assertEquals(expected.getValue(i, j), actual.getValue(i, j));
            }
        }
    }

}
