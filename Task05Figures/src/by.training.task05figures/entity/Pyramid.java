import java.util.List;
import java.util.Objects;

public class Pyramid extends AbstractFigure{

    private String name;
    private int id;

    Pyramid(String name, int id, List<Dot> dots) {
        super(dots);
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pyramid pyramid = (Pyramid) o;
        return id == pyramid.id && Objects.equals(name, pyramid.name) && super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, id);
    }

    @Override
    public String toString() {
        return "Pyramid{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", dots=" + super.toString() +
                '}';
    }
}
