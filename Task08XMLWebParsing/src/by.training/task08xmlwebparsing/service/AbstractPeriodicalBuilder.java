package service;

import entity.Periodical;
import service.exception.ServiceException;

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

    public abstract void buildSetStudents(String fileName) throws ServiceException;

}
