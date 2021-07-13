import java.io.File;
import java.util.List;

import static java.lang.Math.*;

public class PyramidActionImpl implements FigureAction<Pyramid>{

    @Override
    public List<Pyramid> createFromFile(File file) throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        FigureDAO pyramidDAO = daoFactory.getPyramidDAO();
        List<Pyramid> pyramids;
        try {
            pyramids = (List<Pyramid>) pyramidDAO.createFromFile(file);
        } catch (DAOException exception) {
            throw new ServiceException(exception);
        }
        return pyramids;
    }

    @Override
    public double countArea(AbstractFigure figure) {
        AbstractFigure.Dot a1a2 = countNewDot(figure.getDots().get(0), figure.getDots().get(1));
        AbstractFigure.Dot a1a3 = countNewDot(figure.getDots().get(0), figure.getDots().get(2));
        //вектор нормали
        AbstractFigure.Dot baseEdge = new AbstractFigure.Dot(a1a2.getY() * a1a3.getZ() - a1a2.getZ() * a1a3.getY(),
                - (a1a2.getX() * a1a3.getZ() - a1a2.getZ() * a1a3.getX()),
                a1a2.getX() * a1a3.getY() - a1a2.getY() * a1a3.getX());
        //длина вектора нормали
        double baseEdgeVector = countVectorLength(baseEdge);
        //площадь основания
        double baseArea = baseEdgeVector * 0.5;
        //свободный член в уравнении плоскости основания
        double freeTerm = baseEdge.getX() * figure.getDots().get(0).getX()
                + baseEdge.getY() * figure.getDots().get(0).getY()
                + baseEdge.getZ() * figure.getDots().get(0).getZ();
        //длина высоты
        double heightVector = (abs(baseEdge.getX() * figure.getDots().get(3).getX()
                + baseEdge.getY() * figure.getDots().get(3).getY()
                + baseEdge.getZ() * figure.getDots().get(3).getZ() - freeTerm)) / baseEdgeVector;
        return (baseArea * heightVector) / 3;
    }

    @Override
    public double countCapacity(AbstractFigure figure) {
        AbstractFigure.Dot a1a2 = countNewDot(figure.getDots().get(0), figure.getDots().get(1));
        AbstractFigure.Dot a1a3 = countNewDot(figure.getDots().get(0), figure.getDots().get(2));
        AbstractFigure.Dot a1a4 = countNewDot(figure.getDots().get(0), figure.getDots().get(3));
        AbstractFigure.Dot a2a4 = countNewDot(figure.getDots().get(1), figure.getDots().get(3));
        AbstractFigure.Dot a2a3 = countNewDot(figure.getDots().get(1), figure.getDots().get(2));
        AbstractFigure.Dot a3a4 = countNewDot(figure.getDots().get(2), figure.getDots().get(3));
        double a1a2Length = countVectorLength(a1a2);
        double a1a3Length = countVectorLength(a1a3);
        double a1a4Length = countVectorLength(a1a4);
        double a2a4Length = countVectorLength(a2a4);
        double a2a3Length = countVectorLength(a2a3);
        double a3a4Length = countVectorLength(a3a4);
        double leftCapacity = heronCapacity(a1a2Length, a1a4Length, a2a4Length);
        double rightCapacity = heronCapacity(a2a3Length, a2a4Length, a3a4Length);
        double backCapacity = heronCapacity(a1a3Length, a1a4Length, a3a4Length);
        AbstractFigure.Dot baseEdge = new AbstractFigure.Dot(a1a2.getY() * a1a3.getZ() - a1a2.getZ() * a1a3.getY(),
                - (a1a2.getX() * a1a3.getZ() - a1a2.getZ() * a1a3.getX()),
                a1a2.getX() * a1a3.getY() - a1a2.getY() * a1a3.getX());
        //длина вектора нормали
        double baseEdgeVector = countVectorLength(baseEdge);
        //площадь основания
        double baseArea = baseEdgeVector * 0.5;
        return leftCapacity + rightCapacity + backCapacity + baseArea;
    }

    protected Double countVectorLength(AbstractFigure.Dot firstDot) {
        return sqrt(pow(firstDot.getX(),2) + pow(firstDot.getY(), 2) + pow(firstDot.getZ(),2));
    }

    protected AbstractFigure.Dot countNewDot(AbstractFigure.Dot firstDot, AbstractFigure.Dot secondDot) {
        return new AbstractFigure.Dot(secondDot.getX() - firstDot.getX(), secondDot.getY() - firstDot.getY(),
                secondDot.getZ() - firstDot.getZ());
    }

    protected double heronCapacity(double firstSide, double secondSide, double thirdSide) {
        double halfPerimeter = (firstSide + secondSide + thirdSide) / 2;
        return sqrt(halfPerimeter * (halfPerimeter - firstSide) * (halfPerimeter - secondSide) * (halfPerimeter - thirdSide));
    }
}
