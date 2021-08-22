package by.training.Task08XML_WebParsing.service;

import by.training.Task08XML_WebParsing.entity.Periodical;
import by.training.Task08XML_WebParsing.service.exception.ServiceException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class PeriodicalSaxBuilder extends AbstractPeriodicalBuilder {

    private PeriodicalHandler handler = new PeriodicalHandler();
    private XMLReader reader;

    public PeriodicalSaxBuilder() throws ServiceException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
        } catch (ParserConfigurationException | SAXException exception) {
            throw new ServiceException(exception);
        }
        reader.setErrorHandler(new PeriodicalErrorHandler());
        reader.setContentHandler(handler);
    }

    public PeriodicalSaxBuilder(List<Periodical> periodicals) throws ServiceException {
        super(periodicals);
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
        } catch (ParserConfigurationException | SAXException exception) {
            throw new ServiceException(exception);
        }
        reader.setErrorHandler(new PeriodicalErrorHandler());
        reader.setContentHandler(handler);
    }

    @Override
    public void buildSetPeriodicals(String fileName) throws ServiceException {
        try {
            reader.parse(fileName);
        } catch (IOException | SAXException exception) {
            throw new ServiceException(exception);
        }
        periodicals = handler.getPeriodicals();
    }

}
