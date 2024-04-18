/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.NewsDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
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
public class UpdateNewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
           String image = UploadFileUtils.UploadFile(request);
        String MaNews = request.getParameter("ID_News");
        String ID_Types_of_news = request.getParameter("ID_Types_of_news");
        String TenTin = request.getParameter("Name_News");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
//        String image = UploadFileUtils.UploadFile(request);
        
        System.out.println(image);
        String publish_date = request.getParameter("publish_date");
        News tt = new News(Integer.parseInt(MaNews),Integer.parseInt( ID_Types_of_news), TenTin, title, content,image, publish_date);
        NewsDAOImpl ttDao = new NewsDAOImpl();
        ttDao.updateNews(tt);
        request.getRequestDispatcher("/admin/manager_news.jsp").forward(request, response);

    }
    public static void main(String[] args) {
        System.out.println("sss");
    }
}

