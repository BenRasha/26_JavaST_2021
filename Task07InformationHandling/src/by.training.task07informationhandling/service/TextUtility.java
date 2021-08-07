import java.util.Comparator;

public class TextUtility {

    public static void sortParagraphs(TextComponent component) {
        component.getChildren().sort(Comparator.comparingInt(o -> o.getChildren().size()));
    }

    public static void sortLexemes(TextComponent textComponent) {
        for (TextComponent paragraphs : textComponent.getChildren()) {
            for (TextComponent sentence : paragraphs.getChildren()) {
                sentence.getChildren().sort(Comparator.comparingInt(o -> o.toString().length()));
            }
        }
    }

    public static void sortWords(TextComponent textComponent) {
        for (TextComponent paragraph : textComponent.getChildren()) {
            for (TextComponent sentence : paragraph.getChildren()) {
                sentence.getChildren().sort((firstLexeme, secondLexeme) -> {
                    String firstWord = "";
                    String secondWord = "";
                    for (TextComponent component : firstLexeme.getChildren()) {
                        if (component.getType() == TextPartType.WORD) {
                            firstWord = component.toString();
                            break;
                        }
                    }
                    for (TextComponent component : secondLexeme.getChildren()) {
                        if (component.getType() == TextPartType.WORD) {
                            secondWord = component.toString();
                            break;
                        }
                    }
                    return firstWord.length() - secondWord.length();
                });
            }
        }
    }

}
