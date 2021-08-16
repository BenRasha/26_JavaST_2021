package service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class PeriodicalErrorHandler implements ErrorHandler {

    private static final String OUTPUT_CONSTANT = "{} - {}";
    private static Logger errorHandlerLogger = LogManager.getLogger(PeriodicalErrorHandler.class.getName());

    @Override
    public void warning(SAXParseException exception) throws SAXException {
        errorHandlerLogger.warn(OUTPUT_CONSTANT, getLineColumnNumber(exception), exception.getMessage());
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        errorHandlerLogger.error(OUTPUT_CONSTANT, getLineColumnNumber(exception), exception.getMessage());
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        errorHandlerLogger.fatal(OUTPUT_CONSTANT, getLineColumnNumber(exception), exception.getMessage());
    }

    private String getLineColumnNumber(SAXParseException exception) {
        return exception.getLineNumber() + " : " + exception.getColumnNumber();
    }
}
