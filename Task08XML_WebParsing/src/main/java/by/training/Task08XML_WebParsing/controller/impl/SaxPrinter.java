package by.training.Task08XML_WebParsing.controller.impl;

import by.training.Task08XML_WebParsing.controller.command.Command;
import by.training.Task08XML_WebParsing.service.AbstractPeriodicalBuilder;
import by.training.Task08XML_WebParsing.service.exception.ServiceException;
import by.training.Task08XML_WebParsing.service.factory.PeriodicalBuilderFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SaxPrinter implements Command {

    static final Logger saxPrinterLogger = LogManager.getLogger(SaxPrinter.class.getName());

    @Override
    public String execute(String fileName) {
        StringBuilder result = new StringBuilder();
        AbstractPeriodicalBuilder builder = null;
        try {
            builder = PeriodicalBuilderFactory.createPeriodicalBuilder("sax");
            builder.buildSetStudents(fileName);
        } catch (ServiceException exception) {
            saxPrinterLogger.error(exception);
        }
        result.append(String.format("%17s%10s%14s%10s%10s%10s", "Title", "Type", "Periodicity", "Colour", "Capacity"
                , "Cover"));
        for (int i = 0; i < builder.getPeriodicals().size(); i++) {
            result.append("\n").append(String.format("%17s", builder.getPeriodicals().get(i).getTitle()))
                    .append(String.format("%10s", builder.getPeriodicals().get(i).getPaperType()))
                    .append(String.format("%14s", builder.getPeriodicals().get(i).getPeriodicity()))
                    .append(String.format("%10s", builder.getPeriodicals().get(i).getCharacteristic().isColourful()))
                    .append(String.format("%10s", builder.getPeriodicals().get(i).getCharacteristic().getCapacity()))
                    .append(String.format("%10s", builder.getPeriodicals().get(i).getCharacteristic().getCover()));
        }
        return result.toString();
    }

}
