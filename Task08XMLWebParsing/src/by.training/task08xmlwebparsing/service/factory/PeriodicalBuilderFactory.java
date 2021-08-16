package service.factory;

import service.*;
import service.exception.ServiceException;

public class PeriodicalBuilderFactory {

    private PeriodicalBuilderFactory() {
    }

    public static AbstractPeriodicalBuilder createPeriodicalBuilder(String typeParser) throws ServiceException {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                return new PeriodicalDomBuilder();
            case STAX:
                return new PeriodicalsStaxBuilder();
            case SAX:
                return new PeriodicalSaxBuilder();
            default:
                throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
        }
    }
}