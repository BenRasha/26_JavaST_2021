package by.training.Task08XML_WebParsing.service;

import by.training.Task08XML_WebParsing.entity.Periodical;
import by.training.Task08XML_WebParsing.service.exception.ServiceException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class PeriodicalSaxBuilder extends AbstractPeriodicalBuilder {

    private PeriodicalHandler handler = new PeriodicalHandler();
    private XMLReader reader;

    public PeriodicalSaxBuilder() throws ServiceException {
        validate();
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
        validate();
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
    public void buildSetStudents(String fileName) throws ServiceException {
        try {
            reader.parse(fileName);
        } catch (IOException | SAXException exception) {
            throw new ServiceException(exception);
        }
        periodicals = handler.getPeriodicals();
    }

    private void validate() throws ServiceException {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String fileName = "src/main/resources/periodical.xml";
        String schemaName = "src/main/resources/periodical.xsd";
        SchemaFactory schemaFactory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        try {
            Schema schema = schemaFactory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(fileName);
            validator.setErrorHandler(new PeriodicalErrorHandler());
            validator.validate(source);
        } catch (SAXException | IOException exception) {
            throw new ServiceException(exception);
        }
    }

}
