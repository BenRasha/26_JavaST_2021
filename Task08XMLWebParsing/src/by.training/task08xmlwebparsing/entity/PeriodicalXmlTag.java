package entity;

public enum PeriodicalXmlTag {
    PAPERS("papers"),
    ID("id"),
    PAPER("paper"),
    TITLE("title"),
    TYPE("type"),
    MONTHLY("monthly"),
    COLOUR("colour"),
    CAPACITY("capacity"),
    COVER("cover"),
    CHARS("chars");

    private String value;

    PeriodicalXmlTag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
