package service;

import entity.PeriodicalXmlTag;
import entity.Periodical;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;

public class PeriodicalHandler extends DefaultHandler {

    private List<Periodical> periodicals;
    private Periodical current;
    private PeriodicalXmlTag currentXmlTag;
    private EnumSet<PeriodicalXmlTag> withText;
    private static final String ELEMENT_PAPER = "paper";

    public PeriodicalHandler() {
        periodicals = new ArrayList<>();
        withText = EnumSet.range(PeriodicalXmlTag.TITLE, PeriodicalXmlTag.COVER);
    }

    public List<Periodical> getPeriodicals() {
        return periodicals;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if (ELEMENT_PAPER.equals(qName)) {
            current = new Periodical();
            current.setId(attrs.getValue(0));
        } else {
            PeriodicalXmlTag temp = PeriodicalXmlTag.valueOf(qName.toUpperCase());
            if (withText.contains(temp)) {
                currentXmlTag = temp;
            }
        }
    }


    @Override
    public void endElement(String uri, String localName, String qName) {
        if (ELEMENT_PAPER.equals(qName)) {
            periodicals.add(current);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length);
        if (currentXmlTag != null) {
            switch (currentXmlTag) {
                case TITLE:
                    current.setTitle(data);
                    break;
                case TYPE:
                    current.setPaperType(data);
                    break;
                case MONTHLY:
                    current.setPeriodicity(data);
                    break;
                case COLOUR:
                    current.getCharacteristic().setColourful(Boolean.parseBoolean(data));
                    break;
                case CAPACITY:
                    current.getCharacteristic().setCapacity(Integer.parseInt(data));
                    break;
                case COVER:
                    current.getCharacteristic().setCover(data);
                    break;
                default : throw new EnumConstantNotPresentException(
                        currentXmlTag.getDeclaringClass(), currentXmlTag.name());
            }
        }
        currentXmlTag = null;
    }
}
