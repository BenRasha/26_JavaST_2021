public interface ParseHandler {

    void handle(String part, TextComponent component);
    void setHandler(ParseHandler handler);

}
