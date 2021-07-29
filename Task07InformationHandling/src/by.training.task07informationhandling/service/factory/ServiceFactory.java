public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();
    private final ParseHandler textParser = new TextHandler();
    private final ParseHandler sentenceParser = new SentenceHandler();
    private final ParseHandler paragraphParser = new ParagraphHandler();

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        return instance;
    }

    public ParseHandler getParagraphParser() {
        return paragraphParser;
    }

    public ParseHandler getSentenceParser() {
        return sentenceParser;
    }

    public ParseHandler getTextParser() {
        return textParser;
    }
}
