public class Counter {

    /**
     * @param x provided by user real number, same in all methods of this class
     * @return int value of 2*x^4
     */

    public int firstAction (int x) {
        return 2*x*x*x*x;
    }

    /**
     * @return int value of 3x^3
     */

    public int secondAction (int x) {
        return 3*x*x*x;
    }

    /**
     * @return int value of 4x^2
     */

    public int thirdAction (int x) {
        return 4*x*x;
    }

    /**
     * @return int value of 5x
     */

    public int fourthAction (int x) {
        return 5*x;
    }

    /**
     * @return int value of the whole equation
     */

    public int wholeAnswer (int x) {
        return firstAction(x) - secondAction(x) + thirdAction(x) - fourthAction(x) + 6;
    }
}
