package by.training.Task08XML_WebParsing.service;

import by.training.Task08XML_WebParsing.entity.Periodical;
import by.training.Task08XML_WebParsing.service.exception.ServiceException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class PeriodicalDomBuilder extends AbstractPeriodicalBuilder {

    private DocumentBuilder docBuilder;

    public PeriodicalDomBuilder() throws ServiceException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException exception) {
            throw new ServiceException(exception);
        }
    }

    public PeriodicalDomBuilder(List<Periodical> periodicals) throws ServiceException {
        super(periodicals);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException exception) {
            throw new ServiceException(exception);
        }
    }

    @Override
    public void buildSetPeriodicals(String fileName) throws ServiceException {
        Document doc;
        try {
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            NodeList periodicalsList = root.getElementsByTagName("paper");
            for (int i = 0; i < periodicalsList.getLength(); i++) {
                Element periodicalElement = (Element) periodicalsList.item(i);
                Periodical periodical = buildPeriodical(periodicalElement);
                periodicals.add(periodical);
            }
        } catch (IOException | SAXException exception) {
            throw new ServiceException(exception);
        }
    }

    private Periodical buildPeriodical(Element periodicalElement) {
        Periodical periodical = new Periodical();
        periodical.setId(periodicalElement.getAttribute("id"));
        periodical.setTitle(getElementTextContent(periodicalElement, "title"));
        periodical.setPaperType(getElementTextContent(periodicalElement, "type"));
        periodical.setPeriodicity(getElementTextContent(periodicalElement, "monthly"));
        Periodical.Characteristic characteristic = periodical.getCharacteristic();
        Element charElement = (Element) periodicalElement.getElementsByTagName("chars").item(0);
        boolean isColourful = Boolean.parseBoolean(getElementTextContent(charElement, "colour"));
        characteristic.setColourful(isColourful);
        int capacity = Integer.parseInt(getElementTextContent(charElement, "capacity"));
        characteristic.setCapacity(capacity);
        characteristic.setCover(getElementTextContent(charElement, "cover"));
        return periodical;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        String text = node.getTextContent();
        return text;
    }

}
