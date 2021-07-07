import java.util.Comparator;

public class SortPyramidByName implements PyramidSortSpecification{

    @Override
    public Comparator<Pyramid> getComparator() {
        return Comparator.comparing(Pyramid ::getName).thenComparing(Pyramid::getId);
    }
}
