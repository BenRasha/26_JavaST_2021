public class FitChecker {

    /**
     * Used in task four in branching to check whether brick fits the whole
     * @param data object from which we get all the parameters of the hole and brick
     * @return true if brick fits into a hole, and false if not
     */

    public boolean checkWhetherBrickFits (Data data) {
        if ( ( data.getX() >= data.getB() && data.getA() >= data.getC() ) || ( data.getX() >= data.getC() && data.getA() >= data.getB() ) ) {
            return true;
        } else if ( ( data.getX() >= data.getB() && data.getA() >= data.getD() ) || ( data.getX() >= data.getD() && data.getA() >= data.getB() ) ) {
            return true;
        } else if ( (data.getX() >= data.getD() && data.getA() >= data.getC()) || (data.getX() >= data.getC() && data.getA() >= data.getD() ) ) {
            return true;
        } else {
            return false;
        }
    }
}
