/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.TypesOfNewsDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TypesOfNews;

/**
 *
 * @author ACERR
 */
public class UpdateTypeNewServlet extends HttpServlet {

    TypesOfNewsDAOImpl typesOfNewsDAO = new TypesOfNewsDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String nameTypesOfNews = request.getParameter("Name_Types_of_news");
        String idTypesOfNews = request.getParameter("ID_Types_of_news");
        String url = "/admin/manager_typenew.jsp";
        String error = "";

        if (nameTypesOfNews == null || nameTypesOfNews.trim().isEmpty()) {
            error = "Bạn phải nhập tên loại tin";
            request.setAttribute("error", error);
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);
            return;
        }

        TypesOfNews typeNew = new TypesOfNews(Integer.parseInt(idTypesOfNews), nameTypesOfNews);
        typesOfNewsDAO.updateTypesOfNews(typeNew);

        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }

}
