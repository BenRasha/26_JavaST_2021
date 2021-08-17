package by.training.Task08XML_WebParsing.service;

import by.training.Task08XML_WebParsing.entity.Periodical;
import by.training.Task08XML_WebParsing.entity.PeriodicalXmlTag;
import by.training.Task08XML_WebParsing.service.exception.ServiceException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class PeriodicalStaxBuilder extends AbstractPeriodicalBuilder {

    private XMLInputFactory inputFactory;

    public PeriodicalStaxBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }

    public PeriodicalStaxBuilder(List<Periodical> periodicals) {
        super(periodicals);
        inputFactory = XMLInputFactory.newInstance();
    }

    @Override
    public void buildSetStudents(String fileName) throws ServiceException {
        XMLStreamReader reader;
        String name;
        try(FileInputStream inputStream = new FileInputStream(new File(fileName))) {
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (name.equals(PeriodicalXmlTag.PAPER.getValue())) {
                        Periodical periodical = buildPeriodical(reader);
                        periodicals.add(periodical);
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException exception) {
            throw new ServiceException(exception);
        } catch (IOException exception) {
            throw new ServiceException(exception);
        }
    }

    private Periodical buildPeriodical(XMLStreamReader reader) throws XMLStreamException {
        Periodical periodical = new Periodical();
        periodical.setId(reader.getAttributeValue(null, PeriodicalXmlTag.ID.getValue()));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (PeriodicalXmlTag.valueOf(name.toUpperCase())) {
                        case TITLE:
                            periodical.setTitle(getXMLText(reader));
                            break;
                        case TYPE:
                            periodical.setPaperType(getXMLText(reader));
                            break;
                        case MONTHLY:
                            periodical.setPeriodicity(getXMLText(reader));
                            break;
                        case CHARS:
                            periodical.setCharacteristic(getXMLCharacteristic(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (PeriodicalXmlTag.valueOf(name.toUpperCase()) == PeriodicalXmlTag.PAPER) {
                        return periodical;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <paper>");
    }

    private Periodical.Characteristic getXMLCharacteristic(XMLStreamReader reader) throws XMLStreamException {
        Periodical.Characteristic characteristic = new Periodical().new Characteristic();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (PeriodicalXmlTag.valueOf(name.toUpperCase())) {
                        case COLOUR:
                            characteristic.setColourful(Boolean.parseBoolean(getXMLText(reader)));
                            break;
                        case CAPACITY:
                            characteristic.setCapacity(Integer.parseInt(getXMLText(reader)));
                            break;
                        case COVER:
                            characteristic.setCover(getXMLText(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (PeriodicalXmlTag.valueOf(name.toUpperCase()) == PeriodicalXmlTag.CHARS) {
                        return characteristic;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <chars>");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }

}
