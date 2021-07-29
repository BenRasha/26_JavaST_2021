import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {

    private TextPartType type;
    private List<TextComponent> children;

    public TextComposite(TextPartType type) {
        this.type = type;
        children = new ArrayList<>();
    }

    @Override
    public void addChild(TextComponent component) {
        children.add(component);
    }

    @Override
    public List<TextComponent> getChildren() {
        return children;
    }

    @Override
    public TextPartType getType() {
        return type;
    }

    @Override
    public TextComponent getChild(int index) {
        return children.get(index);
    }

    @Override
    public void remove(int index) {
        children.remove(index);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (TextComponent component : children) {
            stringBuilder.append(component.toString());
        }
        return stringBuilder.toString();
    }

}
