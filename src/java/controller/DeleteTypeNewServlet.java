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

/**
 *
 * @author ACERR
 */
public class DeleteTypeNewServlet extends HttpServlet {

    TypesOfNewsDAOImpl TypesOfNewsDAO = new TypesOfNewsDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int ID_Types_of_news = Integer.parseInt(request.getParameter("ID_Types_of_news"));
        String msgDelete = "Chọn danh chức năng mà bạn muốn ?";
        if (TypesOfNewsDAO.deleteTypesOfNews(ID_Types_of_news)) {
            msgDelete = "Xoa thanh cong!";
            request.setAttribute("msgDelete", msgDelete);

        }
        else
        {
             msgDelete = "Xóa không thành công ! Bạn cần xóa hết tin tức thuộc loại tin này !";
            request.setAttribute("msgDelete", msgDelete);
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/manager_typenew.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
