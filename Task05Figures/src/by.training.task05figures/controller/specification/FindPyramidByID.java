public class FindPyramidByID implements PyramidFindSpecification{

    private int searchID;

    public FindPyramidByID(final int id) {
        searchID = id;
    }

    @Override
    public boolean isSpecified(Pyramid entry) {
        return searchID == entry.getId();
    }

    public int getSearchID() {
        return searchID;
    }

    public void setSearchID(int searchID) {
        this.searchID = searchID;
    }
}
