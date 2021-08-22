package by.training.Task08XML_WebParsing.service;

import by.training.Task08XML_WebParsing.entity.Periodical;
import by.training.Task08XML_WebParsing.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPeriodicalBuilder {

    protected List<Periodical> periodicals;

    protected AbstractPeriodicalBuilder() {
        periodicals = new ArrayList<>();
    }

    protected AbstractPeriodicalBuilder(List<Periodical> periodicals) {
        this.periodicals = periodicals;
    }

    public List<Periodical> getPeriodicals() {
        return periodicals;
    }

    public abstract void buildSetPeriodicals(String fileName) throws ServiceException;

}
