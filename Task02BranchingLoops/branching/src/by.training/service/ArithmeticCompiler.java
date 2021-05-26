public class ArithmeticCompiler {

    public int halfSumFinder (Data data) {
        return (data.getX() + data.getA()) / 2;
    }

    public int dualMultiFinder (Data data) {
        return (data.getX() * data.getA()) * 2;
    }

    public void numberReplacer (Data data) {
        ArithmeticCompiler arithmeticCompiler = new ArithmeticCompiler();
        int halfSum = arithmeticCompiler.halfSumFinder(data);
        int dualMul = arithmeticCompiler.dualMultiFinder(data);
        if (data.getX() < data.getA()) {
            data.setX(halfSum);
            data.setA(dualMul);
        } else {
           data.setX(dualMul);
           data.setA(halfSum);
        }
    }
}
