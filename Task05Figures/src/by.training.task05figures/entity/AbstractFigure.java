import java.util.List;
import java.util.Objects;

public abstract class AbstractFigure {

    private List<Dot> dots;

    AbstractFigure(List<Dot> dots) {
        this.dots = dots;
    }

    public List<Dot> getDots() {
        return dots;
    }

    public void setDots(List<Dot> dots) {
        this.dots = dots;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractFigure that = (AbstractFigure) o;
        return Objects.equals(dots, that.dots);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dots);
    }

    @Override
    public String toString() {
        return "AbstractFigure{" +
                "dots=" + dots +
                '}';
    }

    public static class Dot{
        private double x;
        private double y;
        private double z;

        Dot(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        public double getZ() {
            return z;
        }

        public void setZ(double z) {
            this.z = z;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Dot dot = (Dot) o;
            return Double.compare(dot.x, x) == 0 && Double.compare(dot.y, y) == 0 && Double.compare(dot.z, z) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, z);
        }

        @Override
        public String toString() {
            return "Dot{" +
                    "x=" + x +
                    ", y=" + y +
                    ", z=" + z +
                    '}';
        }
    }

}
