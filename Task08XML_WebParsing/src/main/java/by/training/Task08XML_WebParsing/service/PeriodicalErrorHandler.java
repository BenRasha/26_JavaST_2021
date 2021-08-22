package by.training.Task08XML_WebParsing.service;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class PeriodicalErrorHandler implements ErrorHandler {

    @Override
    public void warning(SAXParseException exception) throws SAXException {
        exception.getMessage();
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        exception.getMessage();
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        exception.getMessage();
    }

}
