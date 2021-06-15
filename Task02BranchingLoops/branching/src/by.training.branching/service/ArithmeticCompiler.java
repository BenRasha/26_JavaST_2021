public class ArithmeticCompiler {

    /**
     * Used to complete the second task in branching
     * @param data object, from which we get two provided numbers
     * @return int half sum of two numbers
     */

    public int halfSumFinder (Data data) {
        return (data.getX() + data.getA()) / 2;
    }

    /**
     * Used to complete second task in branching
     * @param data object, from which we get two provided numbers
     * @return int doubled result of multiplication of those two numbers
     */

    public int dualMultiFinder (Data data) {
        return (data.getX() * data.getA()) * 2;
    }

    /**
     * Compares two numbers, and replaces lower one with half of the sum of two numbers, and higher number
     * with doubled result of their multiplication
     * @param data object, from which we get two provided numbers
     */

    public Data numberReplacer (Data data) {
        int halfSum = halfSumFinder(data);
        int dualMul = dualMultiFinder(data);
        if (data.getX() < data.getA()) {
            data.setX(halfSum);
            data.setA(dualMul);
        } else {
           data.setX(dualMul);
           data.setA(halfSum);
        }
        return data;
    }
}
