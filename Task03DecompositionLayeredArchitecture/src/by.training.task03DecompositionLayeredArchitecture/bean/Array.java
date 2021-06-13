import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Array {

    private List<Integer>values = new ArrayList<>();

    public Array(List<Integer> values) {
        this.values = values;
    }

    public Array() {
    }

    public List<Integer> getValues() {
        return values;
    }

    public void setValues(List<Integer> values) {
        this.values = values;
    }

    public void setValue(int value, int index) {
        values.set(index, value);
    }

    public int getValue(int index) {
        return values.get(index);
    }

    public int getLength() {
        return values.size();
    }

    public void swap(int i, int j) {
        int tmp = values.get(i);
        values.set(i, values.get(j));
        values.set(j, tmp);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Array array = (Array) o;
        return Objects.equals(values, array.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public String toString() {
        return "Array{" +
                "values=" + values +
                '}';
    }
}