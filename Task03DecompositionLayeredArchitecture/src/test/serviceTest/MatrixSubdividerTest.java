import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class MatrixSubdividerTest {

    private MatrixSubdivider matrixSubdivider = new MatrixSubdivider();

    @DataProvider(name = "PositiveDataForMatrixSubdivision")
    public Object[][] createDataForMatrixSubdivision() {
        return new Object[][] {
                {new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0} } }
        };
    }

    @Test(description = "Positive scenario for matrix subdivision", dataProvider = "PositiveDataForMatrixSubdivision")
    public void testMatrixSubdivide(int[][] c) throws ServiceException, MatrixException {
        Matrix p = new Matrix();
        Matrix q = new Matrix();
        Matrix actual = matrixSubdivider.completeOperation(p, q);
        Matrix expected = new Matrix(c);
        for (int i = 0; i < actual.getVerticalSize(); i++) {
            for (int j = 0; j < actual.getHorizontalSize(); j++) {
                assertEquals(expected.getValue(i, j), actual.getValue(i, j));
            }
        }
    }

}
