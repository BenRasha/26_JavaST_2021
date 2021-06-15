public class SecondTask {

    /**
     * @return result of 1 + 2 + 4 + ... +2^10.
     */

    public int doCount() {
        int result = 0;
        for (int i = 1; i <= Math.pow(2, 10); i*=2) {
            result += i;
        }
        return result;
    }
}
