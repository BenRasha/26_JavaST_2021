import java.util.ArrayList;
import java.util.List;

public class PyramidRepository {

    private PyramidRepository() {}

    public static List<Pyramid> query(final PyramidSpecification specification, List<Pyramid> pyramids) {
        List<Pyramid> listToReturn = null;
        if (specification instanceof PyramidFindSpecification) {
            listToReturn = new ArrayList<>();
            for (final Pyramid entry : pyramids) {
                if (((PyramidFindSpecification) specification).isSpecified(entry)) {
                    listToReturn.add(entry);
                }
            }
        }
        if (specification instanceof PyramidSortSpecification) {
            listToReturn = new ArrayList<>();
            for (final Pyramid entry : pyramids) {
                listToReturn.add(entry);
                listToReturn.sort(((PyramidSortSpecification) specification).
                        getComparator());
            }
        }
        return listToReturn;
    }
}
