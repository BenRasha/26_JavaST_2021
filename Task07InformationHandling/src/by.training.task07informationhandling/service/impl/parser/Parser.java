public class Parser {

    public ParseHandler getParser() {
        ParseHandler textHandler = new TextHandler();
        ParseHandler paragraphHandler = new ParagraphHandler();
        ParseHandler sentenceHandler = new SentenceHandler();
        ParseHandler wordHandler = new WordHandler();

        textHandler.setNext(paragraphHandler);
        paragraphHandler.setNext(sentenceHandler);
        sentenceHandler.setNext(wordHandler);
        wordHandler.setNext(null);

        return textHandler;
    }

    public TextComponent parseText(String text) {
        return getParser().parse(text);
    }

}
