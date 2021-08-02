public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();
    private final ParseHandler paragraphParser = new ParagraphHandler();
    private final ParseHandler sentenceParser = new SentenceHandler();
    private final ParseHandler lexemeHandler = new LexemeHandler();
    private final ParseHandler wordHandler = new WordHandler();
    private final ParseHandler symbolHandler = new SymbolHandler();
    private final TextFromFileReader textFromFileReader = new TextFromFileReader();

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

    public ParseHandler getLexemeHandler() {
        return lexemeHandler;
    }

    public ParseHandler getWordHandler() {
        return wordHandler;
    }

    public ParseHandler getSymbolHandler() {
        return symbolHandler;
    }

    public TextFromFileReader getTextFromFileReader() {
        return textFromFileReader;
    }
}
