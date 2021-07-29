public interface ParseHandler {

    TextComponent parse(String part);
    void setNext(ParseHandler handler);

}
