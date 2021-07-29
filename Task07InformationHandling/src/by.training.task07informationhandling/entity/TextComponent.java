import java.util.List;

public interface TextComponent {
    void addChild(TextComponent component);
    List<TextComponent> getChildren();
    TextPartType getType();
    TextComponent getChild(int index);
    void remove(int index);
}
