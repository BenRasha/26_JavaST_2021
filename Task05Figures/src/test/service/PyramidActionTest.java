import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.AssertJUnit.assertEquals;

public class PyramidActionTest {

    private PyramidActionImpl pyramidAction = new PyramidActionImpl();

    @DataProvider(name = "PositiveDataForAreaCounting")
    public Object[][] createDataForAreaCounting() {
        return new Object[][] {
                {new AbstractFigure.Dot[]{new AbstractFigure.Dot(2,-3,-1),
                new AbstractFigure.Dot(5,4,2), new AbstractFigure.Dot(-1,-4,3),
                new AbstractFigure.Dot(-5,1,0)}, 47.16},
                {new AbstractFigure.Dot[]{new AbstractFigure.Dot(1,1,5),
                        new AbstractFigure.Dot(2,1,5), new AbstractFigure.Dot(-3,-4,2),
                        new AbstractFigure.Dot(-3,-2,-1)}, 3.5},
        };
    }

    @DataProvider(name = "PositiveDataForVectorLength")
    public Object[][] createDataForVectorLength() {
        return new Object[][] {
                {new AbstractFigure.Dot(1,1,1), 1.73},
                {new AbstractFigure.Dot(0,0,0), 0.0},
                {new AbstractFigure.Dot(2,1,5), 5.48},
                {new AbstractFigure.Dot(-1,-1,2), 2.45}
        };
    }

    @DataProvider(name = "PositiveDataForDotSearch")
    public Object[][] createDataForDotSearch() {
        return new Object[][] {
                {new AbstractFigure.Dot(1,1,1), new AbstractFigure.Dot(2,2,2), new AbstractFigure.Dot(1,1,1)},
                {new AbstractFigure.Dot(0,-1,2), new AbstractFigure.Dot(-3,4,5), new AbstractFigure.Dot(-3,5,3)},
                {new AbstractFigure.Dot(1,2,3), new AbstractFigure.Dot(-5,-4,-3), new AbstractFigure.Dot(-6,-6,-6)}
        };
    }

    @DataProvider(name = "PositiveDataForCapacitySearch")
    public Object[][] createDataForCapacitySearch() {
        return new Object[][] {
                {new AbstractFigure.Dot[]{new AbstractFigure.Dot(1,2,3),
                        new AbstractFigure.Dot(2,-2,1), new AbstractFigure.Dot(3,1,5),
                        new AbstractFigure.Dot(-1,-1,-1)}, 30.61},
                {new AbstractFigure.Dot[]{new AbstractFigure.Dot(1,1,5),
                        new AbstractFigure.Dot(2,1,5), new AbstractFigure.Dot(-3,-4,2),
                        new AbstractFigure.Dot(-3,-2,-1)}, 32.85}
        };
    }

    @DataProvider(name = "PositiveDataForHeron")
    public Object[][] createDataForHeron() {
        return new Object[][] {
                {1.0, 2.0, 3.0, 0.0},
                {2.0, 5.0, 6.0, 4.68},
                {7.0, 10.0, 5.0, 16.25}
        };
    }

    @Test(description = "Positive scenario for area counting", dataProvider = "PositiveDataForAreaCounting")
    public void testAreaCounting(AbstractFigure.Dot[] dots, double c) throws ServiceException {
        double actual = pyramidAction.countArea(new Pyramid("a1a2a3a4", 1, Arrays.asList(dots)));
        double expected = c;
        assertEquals(actual, expected, 0.01);
    }

    @Test(description = "Positive scenario for vector length search", dataProvider = "PositiveDataForVectorLength")
    public void testVectorLength(AbstractFigure.Dot dot, double c) {
        double actual = pyramidAction.countVectorLength(dot);
        double expected = c;
        assertEquals(actual, expected, 0.01);
    }

    @Test(description = "Positive scenario for dot search", dataProvider = "PositiveDataForDotSearch")
    public void testDotSearch(AbstractFigure.Dot first, AbstractFigure.Dot second, AbstractFigure.Dot c) {
        AbstractFigure.Dot actual = pyramidAction.countNewDot(first, second);
        AbstractFigure.Dot expected = c;
        assertEquals(actual, expected);
    }

    @Test(description = "Positive scenario for capacity search", dataProvider = "PositiveDataForCapacitySearch")
    public void testCapacitySearch(AbstractFigure.Dot[] dots, double c) throws ServiceException {
        double actual = pyramidAction.countCapacity(new Pyramid("first", 2, Arrays.asList(dots)));
        double expected = c;
        assertEquals(actual, expected, 0.01);
    }

    @Test(description = "Positive scenario for heron", dataProvider = "PositiveDataForHeron")
    public void testHeron(double first, double second, double third, double c) {
        double actual = pyramidAction.heronCapacity(first, second, third);
        double expected = c;
        assertEquals(actual, expected, 0.01);
    }

}
