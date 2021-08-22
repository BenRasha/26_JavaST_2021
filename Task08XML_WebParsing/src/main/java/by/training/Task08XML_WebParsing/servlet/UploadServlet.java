package by.training.Task08XML_WebParsing.servlet;

import java.io.*;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/upload")
@MultipartConfig(fileSizeThreshold=1024*1024*2,
        maxFileSize=1024*1024*10,
        maxRequestSize=1024*1024*50)
public class UploadServlet extends HttpServlet {

    private static final String SAVE_DIR = "uploadFiles";

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String appPath = request.getServletContext().getRealPath("");
        String savePath = appPath + SAVE_DIR;
        File fileSaveDir = new File(savePath);
        String preFileName = "";
        for(Part part : request.getParts()){
            Collection<String> headers = part.getHeaders("content-disposition");
            if (headers == null)
                continue;
            for(String header : headers) {
                if(header.contains("filename=")) {
                    preFileName = header;
                }
            }
        }
        String[] splitBySpacePreFileName = preFileName.split(" ");
        String fileNameWithData = splitBySpacePreFileName[splitBySpacePreFileName.length - 1];
        String tempStr = fileNameWithData.substring(fileNameWithData.indexOf('"')+1);
        String finalFileName = tempStr.substring(0,tempStr.indexOf('"'));
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        for (Part part : request.getParts()) {
            String fileName = extractFileName(part);
            fileName = new File(fileName).getName();
            if (!fileName.isEmpty()) {
                part.write(savePath + File.separator + fileName);
            }
        }
        request.setAttribute("finalFileName", finalFileName);
        request.setAttribute("parseType", request.getParameter("parseType"));
        getServletContext().getRequestDispatcher("/resultTable").forward(
                request, response);
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }

}