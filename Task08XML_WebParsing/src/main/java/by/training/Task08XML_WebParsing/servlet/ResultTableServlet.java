package by.training.Task08XML_WebParsing.servlet;

import by.training.Task08XML_WebParsing.service.AbstractPeriodicalBuilder;
import by.training.Task08XML_WebParsing.service.exception.ServiceException;
import by.training.Task08XML_WebParsing.service.factory.PeriodicalBuilderFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet(urlPatterns = "/resultTable")

public class ResultTableServlet extends HttpServlet {

    private AbstractPeriodicalBuilder builderFactory;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String parseType = (String) request.getAttribute("parseType");
        String finalFileName = (String) request.getAttribute("finalFileName");
        String appPath = getServletContext().getRealPath("");
        String uploadedFilePath = appPath + "uploadFiles" + File.separator + finalFileName;
        try {
            if (parseType.equals("dom")) {
                builderFactory = PeriodicalBuilderFactory.createPeriodicalBuilder("dom");
                builderFactory.getPeriodicals().clear();
                builderFactory.buildSetPeriodicals(uploadedFilePath);
            } else if (parseType.equals("sax")) {
                builderFactory = PeriodicalBuilderFactory.createPeriodicalBuilder("sax");
                builderFactory.getPeriodicals().clear();
                builderFactory.buildSetPeriodicals(uploadedFilePath);
            } else if (parseType.equals("stax")) {
                builderFactory = PeriodicalBuilderFactory.createPeriodicalBuilder("stax");
                builderFactory.getPeriodicals().clear();
                builderFactory.buildSetPeriodicals(uploadedFilePath);
            }
        } catch (ServiceException exception) {
            exception.printStackTrace();
        }
        request.setAttribute("data", builderFactory.getPeriodicals());
        getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
    }

}
