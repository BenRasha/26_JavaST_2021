import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class RepositoryTest {

    private List<Pyramid> expectedIDSearch = new ArrayList<>();
    private List<Pyramid> expectedNameSearch = new ArrayList<>();
    private List<Pyramid> expectedSort = new ArrayList<>();

    @BeforeClass
    public void createExpectedPyramids() {
        expectedIDSearch.add(new Pyramid("myName", 1, Arrays.asList(new AbstractFigure.Dot(1,2,3),
                new AbstractFigure.Dot(2,5,6), new AbstractFigure.Dot(7,9,0),
                new AbstractFigure.Dot(1,0,-3))));
        expectedIDSearch.add(new Pyramid("searchName",1, Arrays.asList(new AbstractFigure.Dot(0,-2,5),
                new AbstractFigure.Dot(-2,5,6), new AbstractFigure.Dot(7,9,0),
                new AbstractFigure.Dot(1,0,-3))));
        expectedNameSearch.add(new Pyramid("searchName",1, Arrays.asList(new AbstractFigure.Dot(0,-2,5),
                new AbstractFigure.Dot(-2,5,6), new AbstractFigure.Dot(7,9,0),
                new AbstractFigure.Dot(1,0,-3))));
        expectedSort.add(new Pyramid("myName", 1, Arrays.asList(new AbstractFigure.Dot(1,2,3),
                new AbstractFigure.Dot(2,5,6), new AbstractFigure.Dot(7,9,0),
                new AbstractFigure.Dot(1,0,-3))));
        expectedSort.add(new Pyramid("mySecondName", 2, Arrays.asList(new AbstractFigure.Dot(1,2,3),
                new AbstractFigure.Dot(2,5,6), new AbstractFigure.Dot(7,9,0),
                new AbstractFigure.Dot(1,0,-3))));
        expectedSort.add(new Pyramid("searchName",1, Arrays.asList(new AbstractFigure.Dot(0,-2,5),
                new AbstractFigure.Dot(-2,5,6), new AbstractFigure.Dot(7,9,0),
                new AbstractFigure.Dot(1,0,-3))));
    }

    @AfterClass
    public void clear() {
        expectedIDSearch.clear();
        expectedNameSearch.clear();
        expectedSort.clear();
    }

    @DataProvider(name = "PositiveDataForSearch")
    public Object[][] createDataForIDSearch() {
        return new Object[][] {
                {new Pyramid[]{new Pyramid("myName", 1, Arrays.asList(new AbstractFigure.Dot(1,2,3),
                        new AbstractFigure.Dot(2,5,6), new AbstractFigure.Dot(7,9,0),
                        new AbstractFigure.Dot(1,0,-3))),
                new Pyramid("searchName",1, Arrays.asList(new AbstractFigure.Dot(0,-2,5),
                        new AbstractFigure.Dot(-2,5,6), new AbstractFigure.Dot(7,9,0),
                        new AbstractFigure.Dot(1,0,-3))),
                new Pyramid("mySecondName", 2, Arrays.asList(new AbstractFigure.Dot(1,2,3),
                        new AbstractFigure.Dot(2,5,6), new AbstractFigure.Dot(7,9,0),
                        new AbstractFigure.Dot(1,0,-3)))}}
        };
    }

    @Test(description = "Positive scenario for ID search", dataProvider = "PositiveDataForSearch")
    public void testIDSearch(Pyramid[] pyramids) {
        List<Pyramid> actual = PyramidRepository.query(new FindPyramidByID(1), Arrays.asList(pyramids));
        assertEquals(actual, expectedIDSearch);
    }

    @Test(description = "Positive scenario for name search", dataProvider = "PositiveDataForSearch")
    public void testNameSearch(Pyramid[] pyramids) {
        List<Pyramid> actual = PyramidRepository.query(new FindPyramidByName("searchName"), Arrays.asList(pyramids));
        assertEquals(actual, expectedNameSearch);
    }

    @Test(description = "Positive scenario for pyramid sorting", dataProvider = "PositiveDataForSearch")
    public void testPyramidsSort(Pyramid[] pyramids) {
        List<Pyramid> actual = PyramidRepository.query(new SortPyramidByName(),Arrays.asList(pyramids));
        assertEquals(actual, expectedSort);
    }

}
