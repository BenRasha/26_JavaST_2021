import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ParserTest {

    @Test
    public void testParseLexeme() {
        final String WORD = "about";
        ParseHandler wordHandler = new WordHandler();
        wordHandler.setNext(null);
        Assertions.assertEquals(wordHandler.parse(WORD).toString(), WORD);
    }

    @Test
    public void testParseSentence() throws Exception {
        final String SENTENCE = "About this everybody want to talk.";
        ParseHandler wordHandler = new WordHandler();
        wordHandler.setNext(null);
        ParseHandler sentenceHandler = new SentenceHandler();
        sentenceHandler.setNext(wordHandler);
        Assertions.assertEquals(sentenceHandler.parse(SENTENCE).toString(), SENTENCE);
    }

    @Test
    public void testParseSentenceExecute() throws Exception {
        final String SENTENCE = "About this everybody want 1+23+56-(1+56)+2 to talk.";
        ParseHandler wordHandler = new WordHandler();
        wordHandler.setNext(null);
        ParseHandler sentenceHandler = new SentenceHandler();
        sentenceHandler.setNext(wordHandler);
        Assertions.assertEquals(sentenceHandler.parse(SENTENCE).toString(), "About this everybody want 25 to talk.");
    }

}
