public class FindPyramidByName implements PyramidFindSpecification{

    private String searchName;

    public FindPyramidByName(final String name) {
        searchName = name;
    }

    @Override
    public boolean isSpecified(Pyramid entry) {
        return searchName.equals(entry.getName());
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(final String name) {
        this.searchName = name;
    }
}
