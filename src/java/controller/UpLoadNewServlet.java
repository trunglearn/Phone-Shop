/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.NewsDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.News;
import utils.UploadFileUtils;

/**
 *
 * @author ACERR
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 100)
public class UpLoadNewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        int ID_Types_of_news = Integer.parseInt(request.getParameter("ID_Types_of_news"));
        String Name_News = request.getParameter("Name_News");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String date = dateFormat.format(new Date());

        String image = UploadFileUtils.UploadFile(request);
        News tt = new News(ID_Types_of_news, Name_News, title, content, image, date);
        NewsDAOImpl ttDAO = new NewsDAOImpl();
        ttDAO.insertNews(tt);
        request.getRequestDispatcher("/admin/manager_news.jsp").forward(request, response);

    }

}
