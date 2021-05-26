public class ModFinder {

    public int modCounter (Data data) {
        return Math.abs(data.getA() * data.getX() * data.getX() + data.getB() * data.getX() + data.getC());
    }
}
