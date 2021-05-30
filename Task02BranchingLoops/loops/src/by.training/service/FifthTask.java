public class FifthTask {

    private int result;

    /**
     * Crosses out the most significant digit.
     * @param number provided number.
     * @return three-digit number without the most significant digit.
     */

    public int numbersSplit(int number) {
        return number % 100;
    }

    /**
     * Finds three-digit number, which is equal to itself multiplied by 7 without the most significant digit.
     * @return int result of search.
     */

    public int numbersFinder() {
        for (int i = 100; i < 1000; i++) {
            if (numbersSplit(i) * 7 == i) {
                result = i;
            }
        }
        return result;
    }

}
