import java.util.List;
import java.util.Objects;

public class Leaf implements TextComponent {

    private char symbol;
    private TextPartType type;

    public Leaf(TextPartType type) {
        this.type = type;
    }

    public void setSymbol(char symbol) {
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
        return type;
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
        return symbol == leaf.symbol && type == leaf.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, type);
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
