import java.util.List;
import java.util.Objects;

public class Leaf implements TextComponent {

    private String symbol;

    public Leaf(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public void addChild(TextComponent component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<TextComponent> getChildren() {
        return null;
    }

    @Override
    public TextPartType getType() {
        return TextPartType.SYMBOL;
    }

    @Override
    public TextComponent getChild(int index) {
        return null;
    }

    @Override
    public void remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Leaf leaf = (Leaf) o;
        return Objects.equals(symbol, leaf.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }

    @Override
    public String toString() {
        return symbol;
    }
}
